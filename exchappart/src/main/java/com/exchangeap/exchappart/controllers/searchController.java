package com.exchangeap.exchappart.controllers;

import com.exchangeap.exchappart.models.Application;
import com.exchangeap.exchappart.models.Search;
import com.exchangeap.exchappart.repository.ApplicationRepository;
import com.exchangeap.exchappart.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class searchController {
    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    //    @GetMapping("/search")
//    public String searchPage(Model model){
//        Iterable<Application> applications = applicationRepository.findAll();
//        model.addAttribute("applications", applications);
//        return "main-search";
//    }
    @GetMapping("/search/{id}")
    public String searchPage(@PathVariable(value = "id") Long id, org.springframework.ui.Model model) {
        Optional<Search> search = searchRepository.findById(id);

        // Перевірка наявності заявки з заданим id
        if (search.isEmpty()) {
            return "main";
        }

        ArrayList<Search> result = new ArrayList<>();
        search.ifPresent(result::add);
        model.addAttribute("search", result);

        // Пошук варіантів обміну, які задовольняють вимогам фільтра
        List<Application> options = new ArrayList<>();
        Search app = search.get();

        if (app.getFromsearchfloor().equals("null") ||
                app.getTosearchfloor().equals("null") ||
                app.getSearchrooms() == 0 ||
                app.getSearchregion().equals("null")) {
            for (Application option : applicationRepository.findAll()) {
                int fromsearchfloor = app.getFromsearchfloor().equals("null") ? 0 : Integer.parseInt(app.getFromsearchfloor());
                int floor = Integer.parseInt(option.getFloor());
                int tosearchfloor = app.getTosearchfloor().equals("null") ? 0 : Integer.parseInt(app.getTosearchfloor());
                if ((app.getSearchrooms() == 0 || option.getRooms() == app.getSearchrooms()) &&
                        ((fromsearchfloor == 0 && tosearchfloor == 0) ||
                                (floor <= tosearchfloor && floor >= fromsearchfloor)) &&
                        (app.getSearchregion().equals("null") || option.getRegion() == app.getSearchregion())) {
                    options.add(option);
                }
            }
        } else if (app.getFromsearchfloor() != "null" &&
                app.getTosearchfloor() != "null" &&
                app.getSearchrooms() != 0 &&
                app.getSearchregion() != "null") {
            for (Application option : applicationRepository.findAll()) {
                int fromsearchfloor = Integer.parseInt(app.getFromsearchfloor());
                int floor = Integer.parseInt(option.getFloor());
                int tosearchfloor = Integer.parseInt(app.getTosearchfloor());
                if (floor <= tosearchfloor &&
                        floor >= fromsearchfloor) {
                    if (option.getRooms() == app.getSearchrooms()) {
                        if (option.getRegion().equals(app.getSearchregion())) {
                            options.add(option);
                        }
                    }
                }
            }
        }

        if (options.isEmpty()) {
            return "no-search-page";
        }
        model.addAttribute("options", options);
        return "main-search";
    }
}
