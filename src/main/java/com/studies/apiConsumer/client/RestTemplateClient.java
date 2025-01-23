package com.studies.apiConsumer.client;

import com.studies.apiConsumer.request.ListResponseData;
import com.studies.apiConsumer.request.ObjectResponseData;
import com.studies.apiConsumer.request.RequestData;

import java.io.IOException;

public class RestTemplateClient  implements  Client{

    @Override
    public ObjectResponseData get(RequestData requestData) throws IOException {
        return null;
    }

    @Override
    public ListResponseData getAll(RequestData requestData) {
        return null;
    }
}
