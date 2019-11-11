package com.example.demo;

import static java.util.Optional.ofNullable;

import com.example.demo.model.Person;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(fetchPeople());
        System.exit(0);
    }

    private static Collection<Person> fetchPeople() throws URISyntaxException {
        Traverson traverson = new Traverson(new URI("http://localhost:8080/api/persons"), MediaTypes.HAL_JSON);
        return ofNullable(
            traverson
                .follow("$._links.self.href")
                .toObject(new TypeReferences.CollectionModelType<Person>() {
                }))
            .map(CollectionModel::getContent)
            .orElse(Collections.emptyList());
    }
}
