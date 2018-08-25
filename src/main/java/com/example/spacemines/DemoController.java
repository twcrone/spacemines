package com.example.spacemines;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/")
    String home() {
        return "Hello World";
    }
}
