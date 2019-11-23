package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.PersonRepository;
import com.example.demo.paging.OffsetLimitPageable;
import com.example.demo.service.PersonResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PagedResourcesAssembler<Person> pagedAssembler;

    @Autowired
    private PersonResourceAssembler personAssember;

    @GetMapping("/byAge")
    public ResponseEntity<?> findByAge(
        @RequestParam("age") Integer age,
        @RequestParam("offset") int offset,
        @RequestParam("limit") int limit) {

        Page<Person> page = personRepository.findByAge(age, new OffsetLimitPageable(offset, limit));
        return ResponseEntity.ok(pagedAssembler.toModel(page, personAssember));
    }
}
