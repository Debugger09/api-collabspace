package com.ime.collabspace.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Materiel")
public class Materiel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Date dateEnregistrer;

    public Date getDateEnregistrer() {
        return dateEnregistrer;
    }

    public void setDateEnregistrer(Date dateEnregistrer) {
        this.dateEnregistrer = dateEnregistrer;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", dateRecu='" + dateEnregistrer + '\'' +
                '}';
    }

}
