package com.example.l3e7.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends RuntimeException implements GraphQLError {
    //GraphQLError提供变量extensions，可以往error object添加其他数据，并且传给客户端
    private Map<String,Object> extensions = new HashMap<>();

    public DogNotFoundException(String message,Long invalidDogId){
        super(message);
        extensions.put("invalidDogId",invalidDogId);
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return GraphQLError.super.getExtensions();
    }
}
