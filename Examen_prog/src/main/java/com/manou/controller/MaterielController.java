package com.manou.controller;

import com.manou.model.Materiel;
import com.manou.service.MaterielService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MaterielController {
    private MaterielService materielService;

    @GetMapping("/Materiel")
    public List<Materiel> getAllMateriel() {
        return this.materielService.getAllMateriel();
    }

    @GetMapping("/Materiel/id/{id}")
    public Materiel getMaterielById(@PathVariable int id) {
        return this.materielService.getMaterielById(id);
    }

    @PostMapping("/Materiel/insert")
    public Materiel createMateriel(@RequestBody Materiel materiel) {
        return materielService.createMateriel(materiel);
    }

    @PutMapping("/Materiel/{id}")
    public Materiel updateMateriel(@PathVariable int id, @RequestBody Materiel materiel) {
        return materielService.updateMateriel(id, materiel);
    }

    @DeleteMapping("/Materiel/delete/{id}")
    public String deleteMateriel(@PathVariable int id){
        return materielService.deleteMateriel(id);
    }
}
