package com.example.demo.configuration;

import com.example.demo.ApiClient;
import com.example.demo.api.PersonApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath("http://localhost:8080");
    }

    @Bean
    public PersonApi personApi(ApiClient apiClient) {
        return apiClient.buildClient(PersonApi.class);
    }
}
