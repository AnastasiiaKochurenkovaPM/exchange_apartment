package com.exchangeap.exchappart.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class exchangeController {
    @GetMapping("/exchange")
    public String exchangeMain(Model model){
        return "exchange-main";
    }
}