package com.manou.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Personnel {
    private int id ;
    private String nom_personnel;
    private String fonction;
};
