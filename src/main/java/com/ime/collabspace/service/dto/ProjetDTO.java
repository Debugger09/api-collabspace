package com.ime.collabspace.service.dto;

import java.sql.Date;

import com.ime.collabspace.model.User;
import com.ime.collabspace.model.enums.StatutProjet;

public class ProjetDTO {
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private StatutProjet statutProjet;
    private float budget;
    private User chefProjet;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public StatutProjet getStatutProjet() {
        return statutProjet;
    }
    public void setStatutProjet(StatutProjet statutProjet) {
        this.statutProjet = statutProjet;
    }
    public float getBudget() {
        return budget;
    }
    public void setBudget(float budget) {
        this.budget = budget;
    }
    public User getChefProjet() {
        return chefProjet;
    }
    public void setChefProjet(User chefProjet) {
        this.chefProjet = chefProjet;
    }

}
