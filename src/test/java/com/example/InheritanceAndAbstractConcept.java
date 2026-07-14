package com.example;

public abstract class InheritanceAndAbstractConcept {
    public void display() {
        System.out.println("This is from the parent class.");
    }

    public int i=10;

    //For Polymorphism: Overriding Concept
    public void className(){
        System.out.println("Class Name is InheritanceConcept");
    }

    //Abstractmethod
    abstract public void abstractMethod();
}
