package com.manou.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Etat {
    private int id;
    private String type_etat;
    private String description_etat;
}
