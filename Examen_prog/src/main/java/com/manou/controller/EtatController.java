package com.manou.controller;

import com.manou.model.Etat;
import com.manou.service.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtatController {
    private EtatService etatService;

    @GetMapping("/Etat")
    public List<Etat> getAllState() {
        return this.etatService.getAllState();
    }



    @GetMapping("/Etat/{id}")
    public Etat getStateById(@PathVariable int id) {
        return this.etatService.getStateById(id);
    }

    @PostMapping("/Etat/insert")
    public Etat createState(@RequestBody Etat etat) {
        return etatService.createState(etat);
    }

    @PutMapping("/Etat/update/{id}")
    public Etat updateState(@PathVariable int id, @RequestBody Etat etat) {
        return etatService.updateState(id, etat);
    }

    @DeleteMapping("/Etat/delete/{id}")
    public String deleteState(@PathVariable int id){
        return etatService.deleteState(id);
    }
}
