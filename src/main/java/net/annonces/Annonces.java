package net.annonces;

public class Annonces {
    private int id;
    private String titre;
    private String categorie;
    private String contenu;

    public Annonces() {}

    public Annonces(String titre, String categorie, String contenu) {
        this.titre = titre;
        this.categorie = categorie;
        this.contenu = contenu;
    }

    public Annonces(int id, String titre, String categorie, String contenu) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.contenu = contenu;
    }

    // Getters and setters for each field
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
}
