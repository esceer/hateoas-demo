package com.example.demo;

import com.example.demo.model.Person;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;

public class ClientApplication {

    public static void main(String[] args) throws URISyntaxException {
        PagedModel<Person> peopleModel = fetchPeople();
        System.out.println(peopleModel.getContent());
        System.out.println(peopleModel.getMetadata());
    }

    private static PagedModel<Person> fetchPeople() throws URISyntaxException {
        Traverson traverson = new Traverson(new URI("http://localhost:8080/api/persons"), MediaTypes.HAL_JSON);
        return traverson
            .follow("$._links.self.href")
            .toObject(new TypeReferences.PagedModelType<Person>() {
            });
    }
}
