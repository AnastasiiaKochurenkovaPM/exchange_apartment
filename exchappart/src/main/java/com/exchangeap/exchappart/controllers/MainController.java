package com.exchangeap.exchappart.controllers;

import com.exchangeap.exchappart.models.Application;
import com.exchangeap.exchappart.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);
        return "main";
    }
}
