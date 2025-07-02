package com.example.structuralpatterns.adapter;

/**
 * Adaptee: an iPhone that connects via Lightning.
 */
public class iPhone implements LightningPort {
    @Override
    public void connectLightning() {
        System.out.println("iPhone connected with Lightning cable");
    }
    
    //Assign Child instance to Parent
    //Assign Parent Instance to Child
 
    public void m2() {
        System.out.println("iPhone connected with Lightning cable");
    }
}
