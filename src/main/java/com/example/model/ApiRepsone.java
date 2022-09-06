package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)   //added not to send back null in response
public class ApiRepsone<T> implements ApiResponseInterface<T> {
    private T modelObj;
    private String responseMessage;
    public ApiRepsone() {
    }

    public ApiRepsone(T modelObj, String message) {
        this.modelObj = modelObj;
        this.responseMessage = message;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public boolean isSuccessful() {
//        int code = response.getStatusCode();
//        if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205){
//            return true;
//        }
        return false;
    }

    @Override
    public String toString() {
        return "ApiRepsone{" +
                "modelObj=" + modelObj +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }

    public T getModelObj(){
        return this.modelObj;
    }
    public String getTest(){
        return "I am sending all getters to calling API";
    }
}
