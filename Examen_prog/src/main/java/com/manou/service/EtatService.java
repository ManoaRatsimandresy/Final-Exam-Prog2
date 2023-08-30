package com.manou.service;

import com.manou.model.Etat;
import com.manou.repository.EtatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class EtatService {
    private EtatRepository etatRepository;

    public List<Etat> getAllState(){
        try {
            return this.etatRepository.getAllState();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Etat getStateById(int id){
        try {
            return this.etatRepository.getStateById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Etat createState(Etat etat){
        try {
            etatRepository.createState(etat);
            return etat;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;

        }
    }

    public Etat updateState(int id, Etat etat){
        try {
            etat.setId(id);
            etatRepository.updateState(id , etat);
            return etat;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteState(int id){
        try {
            etatRepository.deleteState(id);
            return "Etudiant effacé avec succes";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
