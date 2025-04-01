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

    @Column(name = "date_enregistrer")
    private Date dateEnregistrer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateEnregistrer() {
        return dateEnregistrer;
    }

    public void setDateEnregistrer(Date dateEnregistrer) {
        this.dateEnregistrer = dateEnregistrer;
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
