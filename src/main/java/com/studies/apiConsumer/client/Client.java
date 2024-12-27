package com.studies.apiConsumer.client;

import com.studies.apiConsumer.request.ListResponseData;
import com.studies.apiConsumer.request.ObjectResponseData;
import com.studies.apiConsumer.request.RequestData;

public interface Client {

    public ObjectResponseData get(RequestData request);

    public ListResponseData getAll(RequestData requestData);

}
