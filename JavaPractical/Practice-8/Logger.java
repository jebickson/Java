// File: com/company/util/Logger.java
package com.company.util;

import java.util.Date;

public class Logger {
    private static Logger instance;
    private String logFile;
    
    private Logger() {
        this.logFile = "application.log";
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void warning(String message) {
        log("WARNING", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    private void log(String level, String message) {
        System.out.println("[" + new Date() + "] " + level + ": " + message);
    }
    
    public void setLogFile(String fileName) {
        this.logFile = fileName;
        info("Log file changed to: " + fileName);
    }
}
