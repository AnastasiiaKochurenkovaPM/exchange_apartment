package com.exchangeap.exchappart.controllers;

import ch.qos.logback.core.model.Model;
import com.exchangeap.exchappart.models.Application;
import com.exchangeap.exchappart.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class createController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/create/application")
    public String createPage(Model model){
        return "create-page";
    }
    @PostMapping("/create/application")
    public String availableApartAdd(
            @RequestParam Integer rooms,
            @RequestParam Float area,
            @RequestParam Integer floor,
            @RequestParam String city,
            @RequestParam String region,
            @RequestParam String number,
            @RequestParam Integer wantrooms,
            @RequestParam Float wantarea,
            @RequestParam Integer wantfloor,
            @RequestParam String wantregion,
            Model model){
        Application application = new Application(
                rooms,
                wantrooms,
                floor,
                wantfloor,
                area,
                wantarea,
                city,
                region,
                wantregion,
                number);
        applicationRepository.save(application);
        return "redirect:/";
    }

//    @GetMapping("/create/available/{id}")
//    public String createWantedPage(@PathVariable(value = "id") long id, Model model){
//        availableRepository.
//        return "create-page";
//    }
}
