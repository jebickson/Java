// File: com/company/interfaces/Workable.java
package com.company.interfaces;

public interface Workable {
    void startWork();
    void stopWork();
    void performDuties();
    
    default void takeBreak() {
        System.out.println("Taking a 15-minute break");
    }
}