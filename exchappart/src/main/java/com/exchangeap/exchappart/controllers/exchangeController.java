package com.exchangeap.exchappart.controllers;

import com.exchangeap.exchappart.models.Application;
import com.exchangeap.exchappart.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class exchangeController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/exchange")
    public String exchange(Model model) {
        Iterable<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);
        return "exchange-main";
    }

    @GetMapping("/exchange/{id}")
    public String optionPage(@PathVariable(value = "id") long id, Model model) {
        Optional<Application> application = applicationRepository.findById(id);
        // Перевірка наявності заявки з заданим id
        if (application.isEmpty()) {
            // Обробка ситуації, коли заявка не знайдена
            return "error-page"; // Повертаємо сторінку з повідомленням про помилку
        }


        ArrayList<Application> result = new ArrayList<>();
        application.ifPresent(result::add);
        //application.ifPresent(result::add);
        model.addAttribute("applications", result); // Передаємо заявку у модель для відображення на сторінці

// Пошук варіантів обміну, які задовольняють вимогам заявки
        List<Application> options = new ArrayList<>();
        Application app = application.get();

        if (app.getWantfloor().equals("неважливий") && app.getWantregion().equals("неважливий")) {
            for (Application option : applicationRepository.findAll()) {
                if (option.getId() != app.getId() && // Виключаємо заявку з бази, що має той самий id
                        option.getRooms() == app.getRooms() &&
                        Math.abs(option.getArea() - app.getArea()) / app.getArea() <= 0.1) {
                    if ((option.getWantfloor().equals("неважливий") || option.getWantfloor().equals(app.getFloor()))
                            && (option.getWantregion().equals("неважливий") || option.getWantregion().equals(app.getRegion()))) {
                        options.add(option);
                    }
                }
            }
        } else if (app.getWantregion().equals("неважливий")) {
            for (Application option : applicationRepository.findAll()) {
                if (option.getId() != app.getId() && // Виключаємо заявку з бази, що має той самий id
                        option.getRooms() == app.getRooms() &&
                        Math.abs(option.getArea() - app.getArea()) / app.getArea() <= 0.1) {
                    if ((option.getWantregion().equals("неважливий")  || option.getWantregion().equals(app.getRegion())) &&
                            (option.getWantfloor().equals("неважливий") || option.getWantfloor().equals(app.getFloor())) &&
                            (app.getWantfloor().equals(option.getFloor()))) {
                        options.add(option);
                    }
                }
            }
        } else if (app.getWantfloor().equals("неважливий")) {
            for (Application option : applicationRepository.findAll()) {
                if (option.getId() != app.getId() && // Виключаємо заявку з бази, що має той самий id
                        option.getRooms() == app.getRooms() &&
                        Math.abs(option.getArea() - app.getArea()) / app.getArea() <= 0.1) {
                    if ((option.getWantfloor().equals("неважливий") || option.getWantfloor().equals(app.getFloor())) &&
                            (option.getWantregion().equals("неважливий")  || option.getWantregion().equals(app.getRegion())) &&
                            (app.getWantregion().equals(option.getRegion()))) {
                        options.add(option);
                    }
                }
            }
        } else {
            // Виводимо варіанти, де wantfloor і wantregion співпадають з wantfloor і wantregion заявки
            for (Application option : applicationRepository.findAll()) {
                if (option.getId() != app.getId() && // Виключаємо заявку з бази, що має той самий id
                        option.getRooms() == app.getRooms() &&
                        Math.abs(option.getArea() - app.getArea()) / app.getArea() <= 0.1) {
                    if ((option.getWantfloor().equals(app.getFloor()) && app.getWantfloor().equals(option.getFloor())) &&
                            (option.getWantregion().equals(app.getRegion()) && (app.getWantregion().equals(option.getRegion())))) {
                        options.add(option);
                    }
                }
            }
        }

        if (options.isEmpty()) {
            // Обробка ситуації, коли варіанти обміну не знайдено
            return "no-options-page"; // Повертаємо сторінку з повідомленням про відсутність варіантів
        }

        model.addAttribute("options", options); // Передаємо список варіантів у модель для відображення на сторінці

        return "option-page"; // Повертаємо сторінку зі списком варіантів обміну
    }
}

