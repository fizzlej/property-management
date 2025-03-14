package com.mycompany.propertry_management.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){
        
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel  errorModel = null;
         List<FieldError> fieldErrorsList = manv.getBindingResult().getFieldErrors();

         for(FieldError fe: fieldErrorsList){
            logger.debug("Inside field validation: {} - {}", fe.getField(), fe.getDefaultMessage());
            logger.info("Inside field validation: {} - {}", fe.getField(), fe.getDefaultMessage());
            
            errorModel = new ErrorModel();
            errorModel.setErrorCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
         }
         return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){

        for(ErrorModel em: bex.getErrors()){
            logger.debug("Business exception is thrown - level - debug: {} - {}", em.getErrorCode(), em.getMessage());
            logger.info("Business exception is thrown - level - info: {} - {}", em.getErrorCode(), em.getMessage());
            logger.warn("Business exception is thrown - level - warn: {} - {}", em.getErrorCode(), em.getMessage());
            logger.error("Business exception is thrown - level - error: {} - {}", em.getErrorCode(), em.getMessage());
        }
        
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
