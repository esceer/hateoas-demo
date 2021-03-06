package com.example.demo;

import com.example.demo.api.PersonApi;
import com.example.demo.client.manual.NonGeneratedCustomPersonApi;
import com.example.demo.model.PersonDto;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ClientApplication {

    @Autowired
    private PersonApi personApi;

    @Autowired
    private NonGeneratedCustomPersonApi nonGeneratedCustomPersonApi;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println(fetchFromBackEnd());
            System.out.println(fetchFromBackEndAlternatively());
            sync();
            System.exit(0);
        };
    }

    private List<PersonDto> fetchFromBackEnd() {
        int offset = 2;
        int limit = 5;
        String nameFilter = "Teszt";
        return personApi.list(offset, limit, nameFilter).getEmbedded().getPersons();
    }

    private List<PersonDto> fetchFromBackEndAlternatively() {
        Map<String, Object> parameters = Map.of("offset", 2, "limit", 5, "name", "Teszt", "country", "land");
        return personApi.list(parameters).getEmbedded().getPersons();
    }

    private void sync() {
        System.out.println("initiate syncing");
        nonGeneratedCustomPersonApi.sync();
    }
}
