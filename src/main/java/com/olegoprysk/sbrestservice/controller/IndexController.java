package com.olegoprysk.sbrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RefreshScope
@RestController
public class IndexController {
    public static final UUID uuid = UUID.randomUUID();
    public static final String pattern = "UUID::%s</br>" +
            "Variable_perProfile::%s</br>" +
            "Variable_common::%s</br>" +
            "Profile::%s</br>" +
            "JSON::</br>%s";

    @Autowired
    private Environment environment;

    @Value("${app.test.prop:test}")
    public String variable;

    @Value("${app.common.variable:test}")
    public String commonVariable;


    @Value("${config:{}}")
    public String jsonFile;

    @RequestMapping("/")
    public String index(){
        String[] activeProfiles = environment.getActiveProfiles();
        return String.format(pattern, uuid, variable, commonVariable,  activeProfiles.length > 0 ? activeProfiles[0]:"none", jsonFile);
    }
}
