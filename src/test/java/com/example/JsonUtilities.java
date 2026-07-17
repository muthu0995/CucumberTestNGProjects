package com.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.json.JSONObject;

public class JsonUtilities {

    public static void main(String[] args) throws FileNotFoundException {

String jsonString = "";
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/SampleJson.json"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                jsonString = jsonString + line;
            }
        }catch (Exception e){
            System.out.println("File not found");
        }

        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
        DocumentContext doc = JsonPath.using(configuration).parse(jsonString);
        String analytics = doc.read("$.integrations.analytics").toString();
        String carrier = doc.read("$.tenants[0].orders[0].shipping.carrier").toString();
        String  carrierCondition = doc.read("$.tenants[0].orders[0].shipping[?(@.service==\"Expedited Parcel\")].carrier").toString();
        JSONObject analyticsObj = new JSONObject(analytics);
        analyticsObj.remove("enabled");
        analyticsObj.put("name","Muthu");
        doc.set("$.system.id",123);
        doc = doc.delete("$.system.id");
        doc.add("$.system.metadata.maintainers","{\"id\":1234,\"ii\":123}");



        // Create new endNode
        com.fasterxml.jackson.databind.node.ObjectNode obj = doc.read("$.system");
        obj.put("id", 123);

        //Update map in exsiting
        Map<String, Object> system = new HashMap<>();
        system.put("iid", "123");
        doc.set("$.system", system);
        System.out.println("analytics: " + analytics);


//        DocumentContext main methods: | Method | Purpose |
//                                      |--------|---------|
//                                      | read() | Get value at path |
//                                      | set() | Set/update value at path (objects/properties) |
//                                      | add() | Add value to array at path |
//                                      | delete() | Remove value at path |
//                                      | map() | Transform values at path |

    }
}
