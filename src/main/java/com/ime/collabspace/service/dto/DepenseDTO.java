package com.ime.collabspace.service.dto;

import java.sql.Date;

import com.ime.collabspace.model.Projet;

public class DepenseDTO {
    private Long id;
    private String libelle;
    private float montant;
    private Date dateRecu;
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

}
