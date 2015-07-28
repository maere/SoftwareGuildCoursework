/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.validation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@ControllerAdvice
public class RestValidationHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody()//this is what we are sending back - the JSON onbject for the client to parse
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e){
        //we are going to extract Binding result
        BindingResult result = e.getBindingResult(); //BindingResult is a type... we will bind it to our error
        List<FieldError> fieldErrors = result.getFieldErrors(); //
        
        ValidationErrorContainer errors = new ValidationErrorContainer();
        
        for(FieldError currentError : fieldErrors){//it's going to walk through the entire annotioon and walk through teh errors
            errors.addValidationError(currentError.getField(), currentError.getDefaultMessage()); //this comes from the exception errors--these are the "message" our DTO picks up
        }//end for
        return errors;
    }//end method
    
}//end class
