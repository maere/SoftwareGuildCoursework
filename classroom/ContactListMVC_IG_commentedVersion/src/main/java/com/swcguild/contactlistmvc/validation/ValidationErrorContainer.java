/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.validation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ValidationErrorContainer {
    
    List<ValidationError> validationErrors = new ArrayList<>();
    
    
    public void addValidationError(String fieldName, String message){
        
        ValidationError error = new ValidationError(fieldName, message);
        validationErrors.add(error);
    
    }
    
    public List<ValidationError> getFieldErrors(){
        
        
        return validationErrors;
    }
    
}
