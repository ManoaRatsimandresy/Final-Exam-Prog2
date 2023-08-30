package com.manou.model;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Materiel {
    private int id;
    private String type_materiel;
    private int id_etat;
}
