Create database gestion_parc_informatique;

\c gestion_parc_informatique;
-- Table: Personnel
------------------------------------------------------------
CREATE TABLE Personnel(
	id              SERIAL NOT NULL ,
	nom_personnel   VARCHAR (200)  ,
	fonction        VARCHAR (200) NOT NULL  ,
	CONSTRAINT Personnel_PK PRIMARY KEY (id)
);


------------------------------------------------------------
-- Table: etat
------------------------------------------------------------
CREATE TABLE etat(
	id                 SERIAL NOT NULL ,
	type_etat          VARCHAR (200) NOT NULL ,
	description_etat   VARCHAR (200)  NOT NULL  ,
	CONSTRAINT etat_PK PRIMARY KEY (id)
);


------------------------------------------------------------
-- Table: materiel
------------------------------------------------------------
CREATE TABLE materiel(
	id               SERIAL NOT NULL ,
	type_materiel   VARCHAR (200) NOT NULL ,
	id_etat          INT  NOT NULL  ,
	CONSTRAINT materiel_PK PRIMARY KEY (id)

	,CONSTRAINT materiel_etat_FK FOREIGN KEY (id_etat) REFERENCES etat(id)
);


------------------------------------------------------------
-- Table: utilisation
------------------------------------------------------------
CREATE TABLE utilisation(
	id SERIAL primary key,
	id_materiel             INT  NOT NULL ,
	id_Personnel   INT  NOT NULL ,
	date_debut     TIMESTAMP   ,
	date_fin       TIMESTAMP    ,

	CONSTRAINT utilisation_materiel_FK FOREIGN KEY (id) REFERENCES materiel(id)
	,CONSTRAINT utilisation_Personnel0_FK FOREIGN KEY (id_Personnel) REFERENCES Personnel(id)
);



