package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private Long id;

    private String name;

    private String email;

    private int age;

    private LocalDate birthDate;

    private String birthPlace;

    private Gender gender;

    private boolean hasJob;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            ", birthDate=" + birthDate +
            ", birthPlace='" + birthPlace + '\'' +
            ", gender=" + gender +
            ", hasJob=" + hasJob +
            '}';
    }
}
