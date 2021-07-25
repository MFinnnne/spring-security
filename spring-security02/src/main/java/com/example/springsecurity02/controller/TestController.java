package com.example.springsecurity02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/7/25 18:25
 **/
@RestController
public class TestController {

    @GetMapping("/getUser")
    public String getUser() {
        return "get user";
    }
}
