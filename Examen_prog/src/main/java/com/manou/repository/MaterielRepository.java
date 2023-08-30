package com.manou.repository;

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
        return new Materiel(
                resultSet.getInt("id"),
                resultSet.getString("type_materiel"),
                resultSet.getInt("id_etat"));
    }

    public List<Materiel> getAllMateriel() throws SQLException {
        String sql = "SELECT * FROM materiel";
        List<Materiel> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Materiel getMaterielById(int id_FS) throws SQLException {
        String sql = "SELECT * FROM frais_de_scolarite where id_FS = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id_FS);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
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
