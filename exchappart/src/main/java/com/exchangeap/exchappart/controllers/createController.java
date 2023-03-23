package com.exchangeap.exchappart.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class createController {
    @GetMapping("/create")
    public String createPage(Model model){
        return "create-page";
    }
}
