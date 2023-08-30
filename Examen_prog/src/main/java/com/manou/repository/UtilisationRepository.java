package com.manou.repository;

import com.manou.model.Etat;
import com.manou.model.Materiel;
import com.manou.model.Personnel;
import com.manou.model.Utilisation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class UtilisationRepository {
        private Connection connection;

    public Utilisation createNewInstance(ResultSet resultSet) throws SQLException {
        return new Utilisation(
                resultSet.getInt("id"),
                resultSet.getInt("id_materiel"),
                resultSet.getInt("id_personnel"),
                resultSet.getDate("date_debut").toLocalDate(),
                resultSet.getDate("date_fin").toLocalDate(),
                (new Personnel()),
                (new Materiel()));
    }
        public Utilisation createNewInstanceInfo(ResultSet resultSet) throws SQLException {
            Personnel personnel = new Personnel(
                    resultSet.getInt("id_personnel"),
                    resultSet.getString("nom_personnel"),
                    resultSet.getString("fonction")
            );
            Materiel materiel = new Materiel(
                    resultSet.getInt("id_materiel"),
                    resultSet.getString("type_materiel"),
                    resultSet.getInt("id_etat"),
                    (new Etat())
            );
            return new Utilisation(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_materiel"),
                    resultSet.getInt("id_personnel"),
                    resultSet.getDate("date_debut").toLocalDate(),
                    resultSet.getDate("date_fin").toLocalDate(),
                    personnel,
                    materiel);
        }


    public List<Utilisation> getAllUseInfo() throws SQLException {
        String sql = "SELECT * FROM utilisation JOIN personnel on utilisation.id_personnel = personnel.id JOIN materiel on utilisation.id_materiel = materiel.id";
        List<Utilisation> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            list.add(this.createNewInstanceInfo(resultSet));
        }
        return list;
    }
        public List<Utilisation> getAllUse() throws SQLException {
            String sql = "SELECT * FROM utilisation";
            List<Utilisation> list = new ArrayList<>();
            ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(this.createNewInstance(resultSet));
            }
            return list;
        }



    public Utilisation getUseById(int id) throws SQLException {
        String sql = "SELECT * FROM utilisation where id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
        }


    public void createUse(Utilisation utilisation) throws SQLException {
        String sql = "INSERT INTO utilisation " +"VALUES (?, ?, ?, ?, ? )";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, utilisation.getId());
            statement.setInt(2, utilisation.getId_materiel());
            statement.setInt(3, utilisation.getId_personnel());
            statement.setDate(4, Date.valueOf(utilisation.getDate_debut()));
            statement.setDate(5, Date.valueOf(utilisation.getDate_fin()));

            statement.executeUpdate();
        }
    }

    public void updateUse(int id, Utilisation utilisation) throws SQLException {
        String sql = "UPDATE utilisation SET mode_de_paiements = ?, date_de_paiements = ?, sommes = ?, payer = ?, std = ?, id_mois = ? WHERE id_paiements = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, utilisation.getId_materiel());
            statement.setFloat(2, utilisation.getId_personnel());
            statement.setDate(3, Date.valueOf(utilisation.getDate_debut()));
            statement.setDate(4, Date.valueOf(utilisation.getDate_fin()));
            statement.setInt(5, id);

            statement.executeUpdate();
        }
    }
    public void deleteUse(int id) throws SQLException {
        String sql = "DELETE FROM utilisation WHERE  id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


}

