package com.ime.collabspace.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "depense")
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private float montant;
    private Date dateRecu;

    @ManyToOne
    private Projet projet;

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

    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        this.montant = montant;
    }
    public Date getDateRecu() {
        return dateRecu;
    }
    public void setDateRecu(Date dateRecu) {
        this.dateRecu = dateRecu;
    }
    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public String toString() {
        return "Depense{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", montant=" + montant +
                ", dateRecu=" + dateRecu +
                ", projet=" + projet +
                '}';
    }


}
