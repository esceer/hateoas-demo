package com.example.demo.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private int age;

    private LocalDate birthDate;

    private String birthPlace;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean hasJob;

}
