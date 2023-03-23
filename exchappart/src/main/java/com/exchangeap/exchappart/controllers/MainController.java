package com.exchangeap.exchappart.controllers;

import com.exchangeap.exchappart.models.Available;
import com.exchangeap.exchappart.repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private AvailableRepository availableRepository;
    @GetMapping("/")
    public String main(Model model) {
        Iterable<Available> availables = availableRepository.findAll();
        model.addAttribute("availables", availables);
        return "main";
    }

}
