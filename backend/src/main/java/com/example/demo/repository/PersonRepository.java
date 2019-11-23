package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.QPerson;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface PersonRepository
    extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {

    @RestResource(exported = false)
    Page<Person> findByCountry(String country, Pageable pageable);

    Page<Person> findByName(String name, Pageable pageable);

    Page<Person> findByAge(Integer age, Pageable pageable);

    List<Person> findByAgeAndEmail(Integer age, String email);

    @Query("SELECT p FROM Person p where p.age = :age AND p.email LIKE %:email%")
    List<Person> findByCustom(Integer age, String email);

    @Override
    default void customize(QuerydslBindings bindings, QPerson root) {
        bindings.excluding(root.birthPlace);
        bindings.bind(String.class).first(defaultStringFilter());
    }

    private static SingleValueBinding<StringPath, String> defaultStringFilter() {
        return StringExpression::containsIgnoreCase;
    }
}
