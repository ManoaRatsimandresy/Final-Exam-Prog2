package com.manou.controller;

import com.manou.model.Utilisation;
import com.manou.service.UtilisationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisationController {
    private UtilisationService utilisationService;

    @GetMapping("/Utilisation")
    public List<Utilisation> getAllUse() {
        return this.utilisationService.getAllUse();
    }

    @GetMapping("/Utilisation/Info")
    public List<Utilisation> getAllUseInfo() {
        return this.utilisationService.getAllUseInfo();
    }

    @GetMapping("/Utilisation/id/{id}")
    public Utilisation getUseByStd(@PathVariable int id) {
        return this.utilisationService.getUseById(id);
    }

    @PostMapping("/Utilisation/insert")
    public Utilisation createUse(@RequestBody Utilisation utilisation) {
        return utilisationService.createUse(utilisation);
    }

    @PutMapping("/Utilisation/{id}")
    public Utilisation updateUse(@PathVariable int id, @RequestBody Utilisation utilisation) {
        return utilisationService.updateUse(id, utilisation);
    }

    @DeleteMapping("/Utilisation/delete/{id}")
    public String deleteUse(@PathVariable int id){
        return utilisationService.deleteUse(id);
    }

}
