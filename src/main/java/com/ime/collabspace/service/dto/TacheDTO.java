package com.ime.collabspace.service.dto;

import java.util.Date;

import com.ime.collabspace.model.Projet;
import com.ime.collabspace.model.enums.Priorite;
import com.ime.collabspace.model.enums.StatutTache;

public class TacheDTO {
    private Long id;
    private String libelle;
    private String description;
    private Date dateEcheance;
    private Priorite priorite;
    private StatutTache statutTache;
    private Projet projet;

    // Getters and setters
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }
    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Priorite getPriorite() {
        return priorite;
    }
    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public StatutTache getStatutTache() {
        return statutTache;
    }
    public void setStatutTache(StatutTache statutTache) {
        this.statutTache = statutTache;
    }

    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    

}
