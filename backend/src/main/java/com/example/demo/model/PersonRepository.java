package com.example.demo.model;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findByAge(Integer age, Pageable pageable);

    Page<Person> findByAgeAndEmail(Integer age, String email, Pageable pageable);

    @Query("SELECT p FROM Person p where p.age = :age AND p.email LIKE %:email%")
    List<Person> findByCustom(Integer age, String email);
}
