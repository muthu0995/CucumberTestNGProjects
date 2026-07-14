package com.example;

public class Main extends InheritanceAndAbstractConcept implements InterfaceClass {

    public static void main(String[] args) {

        //Encapsulation
        encapsulationConcept eC = new encapsulationConcept();
        eC.setUsername("Muthu");
        System.out.println("Username: " + eC.getUsername());

        //Inheritance
        Main mainOb = new Main();
        mainOb.i = 10;
        mainOb.display();

        //Polymorphism : method overloading
        mainOb.sum(10, 20);
        mainOb.sum(10, 20, 30);
        //Polymorphism : method overriding
        mainOb.className(); // calling the overridden method
        mainOb.abstractMethod(); // calling the implemented abstract method

        mainOb.displayMessage(); // calling the implemented interface method


    }



    public void sum(int a, int b){
        System.out.println("Sum of a and b: " + (a+b));
    }

    public void sum(int a, int b,int c){
        System.out.println("Sum of a, b and c: " + (a+b+c));
    }

    //For Polymorphism: Overriding Concept
    public void className(){
        super.className(); // super keyword refer parentclass. if we need to call parent method.
        System.out.println("Class Name is Main");
    }

    //For AbstractMethod
    public void abstractMethod(){
     System.out.println("This is the implementation of the abstract method.");
    }

    //For InterfaceMethod
    public void displayMessage(){
        System.out.println("This is the implementation of the interface method.");
    }
}
