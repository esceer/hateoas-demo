package com.example.demo;

import static java.util.Optional.ofNullable;

import com.example.demo.model.Person;
import java.util.Collection;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            System.out.println(fetchPerson(restTemplate));
            System.out.println(fetchPeople(restTemplate));
            System.exit(0);
        };
    }

    private static Person fetchPerson(RestTemplate restTemplate) {
        return restTemplate.getForObject("http://localhost:8080/api/persons/1", Person.class);
    }

    private static Collection<Person> fetchPeople(RestTemplate restTemplate) {
        ResponseEntity<CollectionModel<Person>> response = restTemplate.exchange("http://localhost:8080/api/persons",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<CollectionModel<Person>>() {
            });
        return ofNullable(response.getBody())
            .map(CollectionModel::getContent)
            .orElse(Collections.emptyList());
    }
}
