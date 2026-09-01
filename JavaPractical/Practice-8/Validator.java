// File: com/company/util/Validator.java
package com.company.util;

public class Validator {
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z ]{2,50}");
    }
    
    public static boolean isValidId(int id) {
        return id > 0 && id < 10000;
    }
    
    public static boolean isValidSalary(double salary) {
        return salary > 0 && salary < 1000000;
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
}