package com.domain.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(value ="/status")
    public String get() {
        return "Ok 200";
    }
}
