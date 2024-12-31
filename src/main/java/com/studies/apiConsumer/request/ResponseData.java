package com.studies.apiConsumer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    protected String status;
    protected Map<String, Object> headers = new HashMap<>();
}
