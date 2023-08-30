package com.manou.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Utilisation {
    private  int id;
    private  int id_materiel;
    private int id_personnel;
    private LocalDate date_debut;
    private  LocalDate date_fin;
    private Personnel personnel;
    private Materiel materiel;

}
