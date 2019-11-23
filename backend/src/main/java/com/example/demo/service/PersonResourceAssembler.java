package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

@Service
public class PersonResourceAssembler implements RepresentationModelAssembler<Person, EntityModel<Person>> {

    @Autowired
    private EntityLinks entityLinks;

    @Override
    public EntityModel<Person> toModel(Person person) {
        Link self = entityLinks.linkFor(Person.class).slash(person.getId()).withSelfRel();
        Link rel = entityLinks.linkFor(Person.class).slash(person.getId()).withRel("person");
        return new EntityModel<>(person, self, rel);
    }
}
