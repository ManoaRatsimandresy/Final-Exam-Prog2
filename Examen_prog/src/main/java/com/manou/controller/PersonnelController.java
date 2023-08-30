package com.manou.controller;

import com.manou.model.Personnel;
import com.manou.service.PersonnelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class PersonnelController {
    private PersonnelService personnelService;

    @GetMapping("/Personnel")
    public List<Personnel> getAllPersonnel() {
        return this.personnelService.getAllPersonnel();
    }

    @GetMapping("/Personnel/id/{id}")
    public Personnel getPersonnelByStd(@PathVariable int id) {
        return this.personnelService.getPersonnelById(id);
    }

    @PostMapping("/Personnel/insert")
    public Personnel createPersonnel(@RequestBody Personnel personnel) {
        return personnelService.createPersonnel(personnel);
    }

    @PutMapping("/Personnel/{id}")
    public Personnel updatePersonnel(@PathVariable int id, @RequestBody Personnel personnel) {
        return personnelService.updatePersonnel(id, personnel);
    }

    @DeleteMapping("/Personnel/delete/{id}")
    public String deletePersonnel(@PathVariable int id){
        return personnelService.deletePersonnel(id);
    }

}
