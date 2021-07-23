package com.example.springsecurity01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/7/23 23:49
 **/
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
