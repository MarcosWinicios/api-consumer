package com.studies.apiConsumer.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studies.apiConsumer.request.ListResponseData;
import com.studies.apiConsumer.request.ObjectResponseData;
import com.studies.apiConsumer.request.RequestData;

import java.io.IOException;

public interface Client {

    default ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    default void printTargetUrl(String httpMethod, String url){
        System.out.println("\nTarget API: " + httpMethod + " " + url + "\n");
    }

    default void printExternalServiceResponse(String response){
        System.out.println("Response: \n" + response + "\n");
    }

    public ObjectResponseData get(RequestData requestData) throws IOException;

    public ListResponseData getAll(RequestData requestData);

}
