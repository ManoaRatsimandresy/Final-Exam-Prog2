package com.manou.service;

import com.manou.model.Personnel;
import com.manou.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class PersonnelService {
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel(){
        try {
            return this.personnelRepository.getAllPersonnel();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Personnel getPersonnelById(int id){
        try {
            return this.personnelRepository.getPersonnelById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Personnel createPersonnel(Personnel personnel){
        try {
            personnelRepository.createPersonnel(personnel);
            return personnel;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Personnel updatePersonnel(int id, Personnel personnel){
        try {
            personnel.setId(id);
            personnelRepository.updatePersonnel(id , personnel);
            return personnel;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deletePersonnel(int id){
        try {
            personnelRepository.deletePersonnel(id);
            return "Personnel "+ id +" effacé avec succes" ;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
