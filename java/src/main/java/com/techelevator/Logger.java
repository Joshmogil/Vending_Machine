package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final String PATH_TO_LOG_FILE;
    private final File LOG_FILE;

    public Logger(String pathToLogFile, File logFile) {
        this.PATH_TO_LOG_FILE = pathToLogFile;
        this.LOG_FILE = logFile;
    }

    public Logger(String pathToLogFile) {
        this.PATH_TO_LOG_FILE = pathToLogFile;
        this.LOG_FILE = new File(pathToLogFile);

       try{ LOG_FILE.createNewFile();{ //creates new log file if it does not already exist, can delete this if statement later
       }
       } catch (IOException ioEx){
           System.out.println("I/O exception");
       }

    }
    //Method to write transaction logs to the file
    public String logTransaction(String transactionDetail, Integer money1, Integer money2) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        LocalDateTime logNow = LocalDateTime.now();

        String logDateAndTime = dtf.format(logNow);

        DecimalFormat df = new DecimalFormat("0.00");
        //Converts penny math int to doubles
        Double money1InDollars = Double.valueOf(money1) / 100;
        Double money2InDollars = Double.valueOf(money2) / 100;

        String logEntry = logDateAndTime + " " + transactionDetail + " $" + df.format(money1InDollars) + " $" + df.format(money2InDollars);

        //Appends above log entry to file of a new line
        try(PrintWriter writeToLogFile = new PrintWriter(new FileOutputStream(LOG_FILE,true))) {
            writeToLogFile.println(logEntry);
        } catch (IOException ioEx) {
            System.out.println("I/O Exception");
        }

        return logEntry;

    }

    public void logSeparator() {
        try(PrintWriter writeToLogFile = new PrintWriter(new FileOutputStream(LOG_FILE,true))) {
            writeToLogFile.println("*****");
        } catch (IOException ioEx) {
            System.out.println("Something can go wrong");
        }
    }
}
