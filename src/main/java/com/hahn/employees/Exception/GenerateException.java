package com.hahn.employees.Exception;

public class GenerateException extends RuntimeException{
    public GenerateException(String message, GenerateException e){
        super(message);
    }
}
