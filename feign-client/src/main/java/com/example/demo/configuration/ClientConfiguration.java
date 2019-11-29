package com.example.demo.configuration;

import com.example.demo.ApiClient;
import com.example.demo.api.PersonApi;
import com.example.demo.client.manual.NonGeneratedCustomPersonApi;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
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

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public NonGeneratedCustomPersonApi nonGeneratedPersonApi() {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(NonGeneratedCustomPersonApi.class))
            .logLevel(Logger.Level.FULL)
            .target(NonGeneratedCustomPersonApi.class, "http://localhost:8080");
    }
}
