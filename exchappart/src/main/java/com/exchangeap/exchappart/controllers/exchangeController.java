package com.exchangeap.exchappart.controllers;

import com.exchangeap.exchappart.models.Application;
import com.exchangeap.exchappart.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class exchangeController {
    @Autowired
    private ApplicationRepository applicationRepository;
    @GetMapping("/exchange")
    public String exchange(Model model){
        Iterable<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);
        return "exchange-main";
    }
    @GetMapping("/exchange/{id}")
    public String optionPage(@PathVariable(value = "id") long id, Model model){
        Optional<Application> applications = applicationRepository.findById(id);
        ArrayList<Application> result = new ArrayList<>();
        applications.ifPresent(result::add);
        model.addAttribute("applications", result);
        return "option-page";
    }
}
