package com.ime.collabspace.service.dto;

import java.sql.Date;

public class MaterielDTO {
    private Long id;
    private String libelle;
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
}
