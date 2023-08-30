package com.manou.repository;

import com.manou.model.Etat;
import com.manou.model.Materiel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class MaterielRepository {
    private Connection connection;
    public Materiel createNewInstance(ResultSet resultSet) throws SQLException {
        Etat etat = new Etat(
                resultSet.getInt("id"),
                resultSet.getString("type_etat"),
                resultSet.getString("description_etat")
        );
        return new Materiel(
                resultSet.getInt("id"),
                resultSet.getString("type_materiel"),
                resultSet.getInt("id_etat"),
                etat);
    }

    public Materiel createNewSimpleInstance(ResultSet resultSet) throws SQLException {
        return new Materiel(
                resultSet.getInt("id"),
                resultSet.getString("type_materiel"),
                resultSet.getInt("id_etat"),
                (new Etat()));
    }
    public List<Materiel> getMaterielWithState() throws SQLException {
        String sql = "SELECT * FROM materiel JOIN etat ON materiel.id_etat=etat.id ;";
        List<Materiel> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public List<Materiel> getAllMateriel() throws SQLException {
        String sql = "SELECT * FROM materiel";
        List<Materiel> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewSimpleInstance(resultSet));
        }
        return list;
    }

    public Materiel getMaterielById(int id) throws SQLException {
        String sql = "SELECT * FROM materiel where id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewSimpleInstance(resultSet);
        }
        return null;    }


    public void createMateriel(Materiel materiel) throws SQLException {
        String sql = "INSERT INTO materiel " +"VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, materiel.getId());
            statement.setString(2, materiel.getType_materiel());
            statement.setInt(3, materiel.getId_etat());
            statement.executeUpdate();
        }
    }

    public void updateMateriel(int id, Materiel materiel) throws SQLException {
        String sql = "UPDATE materiel SET type_materiel = ?, id_etat= ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, materiel.getType_materiel());
            statement.setInt(2, materiel.getId_etat());
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    public void deleteMateriel(int id) throws SQLException {
        String sql = "DELETE FROM materiel WHERE  id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
