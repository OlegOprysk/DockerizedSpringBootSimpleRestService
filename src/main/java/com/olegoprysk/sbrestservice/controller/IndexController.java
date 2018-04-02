package com.olegoprysk.sbrestservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IndexController {
    public static final UUID uuid = UUID.randomUUID();
    public static final String pattern = "UUID::%s</br>Variable::%s</br>";

    @Value("${test.prop:thisISDefaultValue}")
    public String variable;

    @RequestMapping("/")
    public String index(){
        return String.format(pattern, uuid, variable);
    }
}
