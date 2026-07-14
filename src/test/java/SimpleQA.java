import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.*;

public class SimpleQA {

    public  static void main(String[] args) {
//    1.What is the difference between == and equals()?
//     == compares the references of two objects, while equals() compares the contents of two objects.

//   2. What is the difference between primitive types and wrapper classes?
        int primitiveInt = 5; // primitive type
        Integer wrapperInt = Integer.parseInt("5"); // wrapper class
//     Primitive types are basic data types (int, char, boolean, etc.) that hold their values directly,
//     while wrapper classes (Integer, Character, Boolean, etc.) provide additional methods and can be used in Collection methods.

//    3. What are Java data types?
//    primitiveType and referenceType
//    Primitive Type are int, float,long,double, boolean;
//    Reference Type are String, Class, Interface, arrays and enum. reference type point object.

//    4.What is type casting in Java?
//    Type casting in Java is converting a variable from one data type to another.
//    two types:
//            1.Widening (Implicit) - smaller to larger type (automatic)
        int i = 5;
        double d = i; // implicit widening
//            2.Narrowing (Explicit) - larger to smaller type (manual)
        int j = (int) d; // explicit narrowing
//
//    With Objects:
//    // Parent → Child (needs cast)
//    Animal animal = new Dog();
//    Dog dog = (Dog) animal;  // explicit cast
//
//    // Child → Parent (automatic)
//    Dog dog = new Dog();
//    Animal animal = dog;     // implicit, always safe


//    5. What are the four main OOP principles?
//      1. Encapsulation : The practice of keeping field within class private, and  provide access by using public method. It helps to protect the instance state of an object array and expose whenever it is necessary.
//      2. Inheritance : the mechanism by which one class can inherit properties and method of another class. It promotes code reusability and establish relationship between classes
//      3. Polymorphism: The ability of different class can be treated as instances of same class through a common interface. It allows methods to do different things based on object it is acting upon.
//    Animal dog = new Dog();
//    Animal cat = new Cat();
//    dog.makeSound();
//    cat.makeSound();
//    It has Method Overloading and Method Overriding. Method Overloading same Method name but different parameter within same class. Method Overriding same method name and same parameter but different class.
//      4. Abstraction: The concept of hiding complex implementation and show only essential information of an object. It helps to reduce code complexity and increase efficiency in code.

//    6. What is Interface
//Interface is complete Abstract class. It group related method with empty bodies.

//    7.What is the difference between List, Set, and Map?
//    List: An ordered collection that allows duplicate elements. Elements can be accessed by their index.
//    Set: An unordered collection that does not allow duplicate elements. It is used to store unique elements.
//    Map: An object that maps keys to values. Each key can map to at most one value, and keys must be unique. It is used for key-value pair storage and retrieval.

        LinkedList<String> list = new LinkedList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        System.out.println("List: " + list);
        System.out.println("List[0]:"+list.get(0));
        list.addFirst("Zero");
        list.remove(0);
        list.remove("Two");
        list.addLast("last");
        list.addLast("apple");
        System.out.println("List: " + list); // it will print in inserted Order
        Collections.sort(list); // it will sort in assending order A-Z then a-Z. First priority goes to uppercase
        System.out.println("Sorted List: " + list);
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER); // it ignore case and sort in assending order
        System.out.println("Sorted List with Case Insensitive: " + list);
        list.sort(Collections.reverseOrder()); // It will reverse by Desc to Asscending
        System.out.println("Sorted List by Desending order: " + list);
        Collections.reverse(list); // It will reverse the insertion order
        System.out.println("Reverse the insertion orderList: " + list);
        System.out.println( list.stream().allMatch(s -> s.isEmpty()));
        System.out.println("List: " + list);

        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        System.out.println("Set: " + set);
        System.out.println("Set[0]:"+set.iterator().next());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Map: " + map);
            for(Map.Entry<String,Integer> givenEntry: map.entrySet()){
            System.out.println("Key: " + givenEntry.getKey() + ", Value: " + givenEntry.getValue());
            }

//        8.What is the difference between ArrayList and LinkedList?
//        ArrayList: It is a resizable array implementation of the List interface. It provides fast random access to elements but slower insertion and deletion operations, especially in the middle of the list.
//        LinkedList: It is a doubly-linked list implementation of the List interface. It provides fast insertion and deletion operations but slower random access to elements.

//        9.StringBuilder vs String vs StringBuffer
//        String: It is immutable, meaning once created, its value cannot be changed. Any modification creates a new String object.
//        StringBuilder: It is mutable and designed for single-threaded use. It provides better performance for string manipulation when thread safety is not a concern.
//        StringBuffer: It is mutable and thread-safe, meaning it can be used in multi-threaded environments. However, it has a performance overhead due to synchronization, making it slower than StringBuilder in single-threaded scenarios.

    }
}
