package com.hahn.employees.Exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " not found with ID: " + id);
    }

}
