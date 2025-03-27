package com.ime.collabspace.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Materiel")
public class Materiel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String dateRecu;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateRecu() {
        return dateRecu;
    }

    public void setDateRecu(String dateRecu) {
        this.dateRecu = dateRecu;
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", dateRecu='" + dateRecu + '\'' +
                '}';
    }

}
