package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Acteur;
import manager.ActeurRepository;

@Controller
@RequestMapping(value ="/action")
public class MainController {

    //Erreur d'intellij, ce n'est pas une vraie erreur
    @Autowired
    private ActeurRepository acteurRepository;

    @GetMapping(path="/addActeur") // Map ONLY GET Requests
    public @ResponseBody String addNewActeur (@RequestParam String name) {

        Acteur n = new Acteur();
        n.setNomAct(name);
        acteurRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allActeurs")
    public @ResponseBody Iterable<Acteur> getAllActeurs() {
        // This returns a JSON or XML with the users
        return acteurRepository.findAll();
    }
}