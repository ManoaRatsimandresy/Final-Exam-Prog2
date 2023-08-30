package com.manou.repository;

import com.manou.model.Personnel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class PersonnelRepository {
    private Connection connection;
    public Personnel createNewInstance (ResultSet resultSet) throws SQLException {
        return new Personnel(
        resultSet.getInt("id"),
        resultSet.getString("nom_personnel"),
        resultSet.getString("fonction")
        );
    }

    public List<Personnel> getAllPersonnel() throws SQLException {
        String sql = "SELECT * FROM personnel";
        List<Personnel> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Personnel getPersonnelById(int id) throws SQLException {
        String sql = "SELECT * FROM personnel where id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }


    public void createPersonnel(Personnel personnel) throws SQLException {
        String sql = "INSERT INTO personnel " +"VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, personnel.getId());
            statement.setString(2, personnel.getNom_personnel());
            statement.setDate(3,Date.valueOf(personnel.getFonction()));
            statement.executeUpdate();
        }
    }

    public void updatePersonnel(int id, Personnel personnel) throws SQLException {
        String sql = "UPDATE personnel SET nom_personnel = ?, fonction = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, personnel.getNom_personnel());
            statement.setString(2, personnel.getFonction());
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    public void deletePersonnel(int id) throws SQLException {
        String sql = "DELETE FROM personnel WHERE  id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
