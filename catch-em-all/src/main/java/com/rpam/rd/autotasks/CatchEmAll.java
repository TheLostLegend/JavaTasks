package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        }
        catch (FileNotFoundException e) {throw new IllegalArgumentException("Resource is missing", e);}
        catch (IOException e) {throw new IllegalArgumentException("Resource error", e);}
        catch (NumberFormatException | ArithmeticException e) {System.err.println(e.getMessage());}

    }
}
/*
IOException	        Wrap in an IllegalArgumentException with a message "Resource error" and throw it
FileNotFoundException	Wrap in an IllegalArgumentException with a message "Resource is missing" and throw it
ArithmeticException or NumberFormatException	Print a message of the thrown exception to System.err and do not throw anything
Any other Exceptions	Should not be caught
*/