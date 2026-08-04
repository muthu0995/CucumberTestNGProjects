package com.example;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.print.Doc;

public class JsonUtilities {
final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static void main(String[] args) throws IOException {

        new JsonUtilities().JsonRead();
        new JsonUtilities().deleteJsonNode();
        new JsonUtilities().addNodeObjectArrayInJson();
        new JsonUtilities().replaceOrUpdateInJson();

//Explanation:
//
//        //Jackson Library Method -> import com.fasterxml.jackson
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(JsonString);
//
//        //Jway Library -> import com.jayway
//        DocumentContext jwayDoc = JsonPath.parse(JsonString);
//
//                Which should you use?
//        Jackson: Best for programmatically modifying JSON trees and handling complex updates.
//        Jayway JsonPath: Best when you already have JsonPath expressions (e.g., $.employee.address.pin, $.employees[?(@.id==1)].name) and want concise delete operations.
//
//                If your framework already stores paths in JsonPath format (e.g., $.employee.address.pin), then DocumentContext.delete(path) is the simplest solution.
//                If your paths are in dot notation (e.g., employee.address.pin), Jackson or a conversion to JsonPath may be more appropriate.
//
//
//        //read
//        Object tenantID = doc.read("$.tenants[0].tenantId"); -> Jway
//        String tenantID1 = jsonNode.at("/tenants/0/tenantId").asText(); -> Jackson

//        //delete
//        doc.delete("$.system.id"); -> Jway
//        objectNode.remove("id"); -> Jackson: To delete any field or Object, we need to convert to ObjectNode. JsonNode -> ObjectNode
//        arrayNode.remove(0); -> Jackson: To delete array index, we need to convert to ArrayNode. JsonNode -> ArrayNode

//        //add
//        doc.put("$.system.features","name","Muthu"); -> Jway
//        objectNode.put("name","Kumar"); -> Jackson: To add any field, we need to convert to ObjectNode. JsonNode -> ObjectNode
//        doc.put("$.security.policies","newElements",hashmap); -> Jway: To add JSONObject, we need to create HashMap. HashMap will be considered as Object
//        policies.put("newElements",newObjectNode); -> Jackson: To add JSONObject, we need to create ObjectNode.
//        doc.put("$.security.policies","newArray",newJsonArray); -> Jway: To add JSONArray, we need to create List of HashMap. List of HashMap will be considered as Array
//        policies.put("newDirectArray",newArrayNode); -> Jackson: To add JSONArray, we need to create ArrayNode. Add ObjectNode in Arraynode ex: ArrayNode.add(Objectnode);

//        //update or replace
//        doc.set("$.system.id","20345165"); -> Jway: To replace field
//        objectNode.put("id","20345165"); -> Jackson: To replace field
//        doc.set("$.system.regions",HashMap); -> Jway: To replace JSONObject, we need to create HashMap. HashMap will be considered as Object
//        objectNode.set("regions",newObjectNode); -> Jackson: To replace JSONObject, we need to create ObjectNode.
//        doc.set("$.system.regions",List<Map<>>); -> Jway: To replace JSONArray, we need to create List of HashMap. List of HashMap will be considered as Array
//        objectNode.set("regions",arrayNode); -> Jackson: To replace JSONArray, we need to create ArrayNode. Add ObjectNode in Arraynode ex: ArrayNode.add(Objectnode);


//        DocumentContext main methods: | Method | Purpose |
//                                      |--------|---------|
//                                      | read() | Get value at path |
//                                      | set() | Set/update value at path (objects/properties) |
//                                      | add() | Add value to array at path |
//                                      | delete() | Remove value at path |
//                                      | map() | Transform values at path |

    }


    public String readJsonFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/SampleJson.json"));
        String line;
        String jsonString = "";
        while((line=reader.readLine())!=null){
            jsonString = jsonString + line;
        }
        reader.close();
        return jsonString;
    }

    public void JsonRead() throws IOException {
        String JsonString = readJsonFromFile();

        //To get jsonString as DocumentContext
        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
        DocumentContext doc = JsonPath.using(configuration).parse(JsonString);

        //Jackson Method
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(JsonString);

        //Jway
        DocumentContext jwayDoc = JsonPath.parse(JsonString);

        //Read endNode
        Object tenantID = doc.read("$.tenants[0].tenantId");
        System.out.println("tenantID: " + tenantID); //-> this using JacksonJsonNodeJsonProvider ->JsonPath.using(configuration).parse(JsonString); So it will return with ""(Double Quote)
        tenantID = jwayDoc.read("$.tenants[0].tenantId");
        System.out.println("tenantID: " + tenantID); //-> this using DefaultProvider ->JsonPath.parse(JsonString);
        String tenantID1 = jsonNode.at("/tenants/0/tenantId").asText();
        System.out.println("tenantID: " + tenantID1);
        tenantID1 = readJacksonDotNotation(jsonNode,"tenants.0.tenantId").toString();
        System.out.println("Jackson tenantID: " + tenantID1);
        String tenants = readJacksonDotNotation(jsonNode,"tenants").toString();
        System.out.println("Jackson tenants Array: " + tenants);
        tenants = readJacksonDotNotation(jsonNode,"tenants.0").toString();
        System.out.println("Jackson tenants Object: " + tenants);

        Object carrierCondition = doc.read("$.tenants[0].orders[0].shipping[?(@.service==\"Expedited Parcel\")].carrier").toString();
        System.out.println("carrierCondition: " + carrierCondition);
        carrierCondition = jwayDoc.read("$.tenants[0].orders[0].shipping[?(@.service==\"Expedited Parcel\")].carrier").toString();
        System.out.println("carrierCondition: " + carrierCondition);


    }

    public Object readJacksonDotNotation(JsonNode jsonNode, String path){
        String keys[] = path.split("\\.");
        JsonNode currentNode=jsonNode;
        for(String key:keys){

            //this if else only handle jsonObject not JsonArray
//            if(currentNode.get(key)!=null){
//                currentNode = currentNode.get(key);
//            }else
//                return null;

            boolean array = key.matches("\\d+");
            if(array)
                currentNode = currentNode.get(Integer.parseInt(key));
            else if (currentNode.get(key)!=null)
                currentNode = currentNode.get(key);
            else
                return null;
        }

        if(currentNode.isValueNode())
            return currentNode.asText();
        else if(currentNode.isBoolean())
            return currentNode.asBoolean();
        else if (currentNode.isInt())
            return currentNode.asInt();
        else if(currentNode.isDouble())
            return currentNode.asDouble();
        else if(currentNode.isLong())
            return currentNode.asLong();
        else if (currentNode.isObject())
            return currentNode;
        else if(currentNode.isArray())
            return currentNode;

        //if nothing matches
        return null;

    }

    public void deleteJsonNode() throws IOException {
        String jsonString = readJsonFromFile();

        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
        DocumentContext doc = JsonPath.using(configuration).parse(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        DocumentContext jwayDoc = JsonPath.parse(jsonString);

        doc.delete("$.system.id");
        System.out.println("After deleting system.id using JacksonJsonNodeJsonProvider: " + doc.jsonString());
        jwayDoc.delete("$.system.id");
        System.out.println("After deleting system.id using DefaultProvider: " + jwayDoc.jsonString());

        //To Delete from JsonNode convert to ObjectNode
        ObjectNode objectNode = (ObjectNode)jsonNode.get("system");
        objectNode.remove("id");
        System.out.println("After deleting system.id using Jackson JsonNode: " + jsonNode.toString());

        objectNode.remove("features");
        System.out.println("After deleting system.features Object: " + jsonNode.toString());

        ArrayNode arrayNode = (ArrayNode) jsonNode.get("tenants");
        arrayNode.remove(0);
        System.out.println("After deleting system.features Array: " + jsonNode.toString());

        doc.delete("$.tenants[0].orders[0].shipping[?(@.service==\"Expedited Parcel\")].carrier");
        System.out.println("carrierCondition: " + doc.jsonString());
        jwayDoc.delete("$.tenants[0].orders[0].shipping[?(@.service==\"Expedited Parcel\")].carrier");
        System.out.println("carrierCondition: " + jwayDoc.jsonString());
        jwayDoc.delete("$.tenants[0].orders[0].shipping");
        System.out.println("Jway Delete -> shipping Object: " + jwayDoc.jsonString());
        jwayDoc.delete("$.tenants[0].orders[0]");
        System.out.println("Jway Delete -> orders[0] Object: " + jwayDoc.jsonString());
        jwayDoc.delete("$.tenants[0].orders");
        System.out.println("Jway Delete -> orders Array: " + jwayDoc.jsonString());




    }

    public void addNodeObjectArrayInJson() throws IOException {
        String jsonString = readJsonFromFile();

        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
        DocumentContext doc = JsonPath.using(configuration).parse(jsonString);

        DocumentContext jwayDoc = JsonPath.parse(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);


        //addEndNode
        doc.put("$.system.features","name","Muthu");
        System.out.println("Jway After adding endNode:"+doc.jsonString());
        ObjectNode feature = (ObjectNode)jsonNode.at("/system/features");
        feature.put("name","Kumar");
        System.out.println("Jackson After adding endNode:"+jsonNode.toString());

        //add new jsonObject
        Map<String,Object> newObject = new LinkedHashMap<>();
        newObject.put("firstElement","1");
        newObject.put("secondElement",2);
        newObject.put("thirdElement",true);
        doc.put("$.security.policies","newElements",newObject);
        System.out.println("Jway After adding Object:"+doc.jsonString());
        ObjectNode newObjectNode = objectMapper.createObjectNode();
        newObjectNode.put("firstElement","1");
        newObjectNode.put("secondElement",2);
        newObjectNode.put("thirdElement",true);
        ObjectNode policies = (ObjectNode)jsonNode.at("/security/policies");
        policies.put("newElements",newObjectNode);
        System.out.println("Jackson After adding Object:"+jsonNode.toString());

        //add new jsonArray
        List<Map<String,Object>> newJsonArray = new LinkedList<Map<String,Object>>();
        newJsonArray.add(newObject);
        doc.put("$.security.policies","newArray",newJsonArray);
        List<String>directlist = new LinkedList<>();
        directlist.add("One");
        directlist.add("Two");
        directlist.add("Three");
        doc.put("$.security.policies","newDirectArray",directlist);
        System.out.println("Jway After adding Array:"+doc.jsonString());

        ArrayNode newArrayNode = objectMapper.createArrayNode();
        newArrayNode.add(newObjectNode);
        policies = (ObjectNode)jsonNode.at("/security/policies");
        policies.put("newArray",newArrayNode);
        ArrayNode newDirectArrayNode = objectMapper.createArrayNode();
        newDirectArrayNode.add("One");
        newDirectArrayNode.add("Two");
        newDirectArrayNode.add("Three");
        policies.put("newDirectArray",newDirectArrayNode);
        System.out.println("Jackson After adding Object:"+jsonNode.toString());
    }

    public void replaceOrUpdateInJson() throws IOException {
        String jsonString = readJsonFromFile();

        DocumentContext doc = JsonPath.parse(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        //updating field
        doc.set("$.system.id","20345165");
        System.out.println("Jway After replacing system.id:"+doc.jsonString());
        ObjectNode objectNode = (ObjectNode)jsonNode.get("system");
        objectNode.put("id","20345165");
        System.out.println("Jackson After replacing system.id:"+jsonNode.toString());

        //updating jsonObject
        Map<String,Object> newObject = new LinkedHashMap<>();
        newObject.put("firstElement","1");
        newObject.put("secondElement",2);
        newObject.put("thirdElement",true);
        doc.set("$.system.regions",newObject);
        System.out.println("Jway After replacing system.regions:"+doc.jsonString());
        objectNode = (ObjectNode)jsonNode.get("system");
        ObjectNode newObjectNode = objectMapper.createObjectNode();
        newObjectNode.put("firstElement","1");
        newObjectNode.put("secondElement",2);
        newObjectNode.put("thirdElement",true);
        objectNode.set("regions",newObjectNode);
        System.out.println("Jackson After replacing system.regions:"+jsonNode.toString());


        //updating jsonArray
        List<Map<String,Object>> newJsonArray = new LinkedList<Map<String,Object>>();
        newJsonArray.add(newObject);
        doc.set("$.system.regions",newJsonArray);
        System.out.println("Jway After replacing system.regions Array:"+doc.jsonString());
        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add(newObjectNode);
        objectNode.set("regions",arrayNode);
        System.out.println("Jackson After replacing system.regions Array:"+jsonNode.toString());


    }
}
