package com.yash.graphql_demo.exception;

import graphql.GraphQLException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VenueNotFoundException.class)
    public GraphQLException handleUserNotFoundException(VenueNotFoundException ex) {
        return new GraphQLException(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public GraphQLException handleGenericException(Exception ex) {
        return new GraphQLException("Internal Server Error");
    }
}
