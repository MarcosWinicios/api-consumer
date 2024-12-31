package com.studies.apiConsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studies.apiConsumer.client.Client;
import com.studies.apiConsumer.dto.ViaCepAddressDTO;
import com.studies.apiConsumer.model.Address;
import com.studies.apiConsumer.request.ObjectRequestData;
import com.studies.apiConsumer.request.ObjectResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private Client client;
    private final String baseUrl =  "http://viacep.com.br/ws";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ViaCepService(Client client){
        this.client = client;
    }

    public Address getCep(String cep) {

        ObjectRequestData requestData = new ObjectRequestData();
        
        requestData.setUrl(baseUrl + "/" + cep + "/json/");

        try {
            ObjectResponseData responseData = client.get(requestData);
            ViaCepAddressDTO viaCepAddress = new ViaCepAddressDTO(responseData.getBody());
            return viaCepAddress.toAddress();
        }catch (Exception e){
            throw new RuntimeException("Erro ao consumir o serviço: " + requestData.getUrl() + "\n" + e.getMessage());
        }
    }
}
