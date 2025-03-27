package com.ime.collabspace.service.dto;

public class MaterielDTO {
    private Long id;
    private String libelle;
    private String dateRecu;
    
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
    public String getDateRecu() {
        return dateRecu;
    }
    public void setDateRecu(String dateRecu) {
        this.dateRecu = dateRecu;
    }

}
