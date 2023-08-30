package com.manou.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class GetConnection {

    @Bean
    public Connection test() throws SQLException{
        return DriverManager.getConnection (
                "jdbc:postgresql://localhost:5432/gestion_parc_informatique",
                "postgres",
                "123KyrieIrving"
        );
    }
}
