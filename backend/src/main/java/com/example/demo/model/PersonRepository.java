package com.example.demo.model;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    @RestResource(exported = false)
    Page<Person> findByCountry(String country, Pageable pageable);

    Page<Person> findByAge(Integer age, Pageable pageable);

    List<Person> findByAgeAndEmail(Integer age, String email);

    @Query("SELECT p FROM Person p where p.age = :age AND p.email LIKE %:email%")
    List<Person> findByCustom(Integer age, String email);
}
