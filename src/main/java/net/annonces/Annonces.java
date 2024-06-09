package net.annonces;

import java.sql.Date;

public class Annonces {
    private int id;
    private String titre;
    private String categorie;
    private String contenu;
    private Date startDate;
    private Date endDate;

    public Annonces(int id, String titre, String categorie, String contenu, Date startDate, Date endDate) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.contenu = contenu;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Annonces() {
    	
    }

    // Getters and setters for all fields, including startDate and endDate
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

