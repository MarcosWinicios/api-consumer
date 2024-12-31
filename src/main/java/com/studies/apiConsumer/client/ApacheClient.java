package com.studies.apiConsumer.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.studies.apiConsumer.request.ListResponseData;
import com.studies.apiConsumer.request.ObjectResponseData;
import com.studies.apiConsumer.request.RequestData;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Data
@Component
public class ApacheClient implements Client {

    private String name = "Apache client";

    @Override
    public ObjectResponseData get(RequestData requestData) throws IOException {
        this.printTargetUrl("GET", requestData.getUrl());

        ObjectResponseData responseData = new ObjectResponseData();

        HttpGet request = new HttpGet(requestData.getUrl());
        request.addHeader("Accept", "application/json");

        if(requestData.getHeaders() != null){
            requestData.getHeaders().forEach(request::addHeader);
        }

        try (
                CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
                CloseableHttpResponse response = httpClient.execute(request)
        ) {
            HttpEntity entity = response.getEntity();
            if(entity == null){
                throw new RuntimeException("Empty response entity");
            }

            String responseBodyJson = EntityUtils.toString(entity);

            int responseStatusCode = response.getStatusLine().getStatusCode();
            responseData.setStatus(String.valueOf(responseStatusCode));

            if(!(responseStatusCode >= 200  && responseStatusCode <= 299)){
                System.err.println(response.getStatusLine().getReasonPhrase().toString());

                throw new RuntimeException("Error in request: GET " + requestData.getUrl());
            }

            if(response.getAllHeaders().length > 0){
                Arrays.stream(response.getAllHeaders())
                        .forEach( header -> responseData.getHeaders()
                                .put(header.getName(), header.getValue()));
            }

            this.printExternalServiceResponse(responseBodyJson);

            Map<String, Object> responseBody = getObjectMapper().readValue(responseBodyJson, new TypeReference<>() {});

            responseData.setBody(responseBody);

        }
        return responseData;
    }


    @Override
    public ListResponseData getAll(RequestData requestData) {
        return null;
    }
}
