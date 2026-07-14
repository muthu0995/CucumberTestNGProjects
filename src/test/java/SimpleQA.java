public class SimpleQA {

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
    int i=5;
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





}
