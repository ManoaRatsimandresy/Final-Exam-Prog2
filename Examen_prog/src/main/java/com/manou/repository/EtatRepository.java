package com.manou.repository;

import com.manou.model.Etat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class EtatRepository {
    private Connection connection;
    public Etat createNewInstance(ResultSet resultSet) throws  SQLException{
        return new Etat(
            resultSet.getInt("id"),
            resultSet.getString("type_etat"),
            resultSet.getString("description_etat"));
    }

    public void createState(Etat etat) throws SQLException {
        String sql = "INSERT INTO etat " +
                "VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, etat.getId());
            statement.setString(2, etat.getType_etat());
            statement.setString(3, etat.getDescription_etat());
            statement.executeUpdate();
        }
    }
    public List<Etat> getAllState() throws SQLException {
        String sql = "SELECT * FROM etat";
        List<Etat> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }


    public Etat getStateById(int id) throws SQLException {
        String sql = "SELECT * FROM etat where id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }

    public void updateState(int id, Etat etat) throws SQLException {
        String sql = "UPDATE etat SET type_etat = ?, description_etat = ? " +
                " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, etat.getType_etat());
            statement.setString(2, etat.getDescription_etat());
            statement.setInt(3, id);

            statement.executeUpdate();
        }
    }

    public void deleteState(int id) throws SQLException {
        String sql = "DELETE FROM etat WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}