package com.manou.service;

import com.manou.model.Materiel;
import com.manou.repository.MaterielRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class MaterielService {
    private MaterielRepository materielRepository;

    public List<Materiel> getMaterielsWithState() {
        try {
            return this.materielRepository.getMaterielWithState();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Materiel> getAllMateriel() {
        try {
            return this.materielRepository.getAllMateriel();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Materiel getMaterielById(int id) {
        try {
            return this.materielRepository.getMaterielById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Materiel createMateriel(Materiel materiel) {
        try {
            materielRepository.createMateriel(materiel);
            return materiel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Materiel updateMateriel(int id, Materiel materiel) {
        try {
            materiel.setId(id);
            materielRepository.updateMateriel(id, materiel);
            return materiel;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteMateriel(int id) {
        try {
            materielRepository.deleteMateriel(id);
            return "Materiels Suprrimé";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
