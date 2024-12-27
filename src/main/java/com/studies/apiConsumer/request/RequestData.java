package com.studies.apiConsumer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {

    protected String url;
    protected Map<String, Object> queryParams;
    protected Map<String, String> headers;
}
