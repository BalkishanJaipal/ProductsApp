package com.products.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public  ResourceNotFoundException(String resourceName ,String fieldName ,Long fieldValue){
        super(String.format("%s is not found with %s : %d", resourceName, fieldName, fieldValue));
        this.fieldName = fieldName;
        this.resourceName =resourceName;
        this.fieldValue = fieldValue;
    }
}
