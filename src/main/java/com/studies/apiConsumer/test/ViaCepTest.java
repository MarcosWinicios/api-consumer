package com.studies.apiConsumer.test;

import com.studies.apiConsumer.ApiConsumerApplication;
import com.studies.apiConsumer.model.Address;
import com.studies.apiConsumer.service.ViaCepService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class ViaCepTest {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext =  new SpringApplicationBuilder(ApiConsumerApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ViaCepService viaCepService = applicationContext.getBean(ViaCepService.class);

        Address address = viaCepService.getCep("76360000f");

        System.out.println(address);
    }
}
