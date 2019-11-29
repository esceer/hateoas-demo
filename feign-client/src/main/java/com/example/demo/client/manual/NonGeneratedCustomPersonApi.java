package com.example.demo.client.manual;

import feign.RequestLine;

public interface NonGeneratedCustomPersonApi {

    @RequestLine("POST /custom/persons/sync")
    void sync();
}
