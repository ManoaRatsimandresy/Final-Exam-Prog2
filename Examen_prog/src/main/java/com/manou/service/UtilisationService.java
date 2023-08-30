package com.manou.service;
import com.manou.model.Utilisation;
import com.manou.repository.UtilisationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class UtilisationService {
    private UtilisationRepository utilisationRepository;

    public List<Utilisation> getAllUseInfo(){
        try {
            return this.utilisationRepository.getAllUseInfo();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Utilisation> getAllUse(){
        try {
            return this.utilisationRepository.getAllUse();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Utilisation getUseById(int id){
        try {
            return this.utilisationRepository.getUseById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Utilisation createUse(Utilisation utilisation){
        try {
            utilisationRepository.createUse(utilisation);
            return utilisation;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Utilisation updateUse(int id, Utilisation utilisation){
        try {
            utilisation.setId(id);
            utilisationRepository.updateUse(id , utilisation);
            return utilisation;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteUse(int id){
        try {
            utilisationRepository.deleteUse(id);
            return "Utilisation : "+id + " effacé avec succes";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }



}
