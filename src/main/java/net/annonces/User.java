package net.annonces;

import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;

public class User {
    private String email;
    private String password;
    private String photo;

    public User(String email, String password, String photo) {
        this.email = email;
        this.password = password;
        this.photo = photo;
    }
    public User() {}

    // Getters et setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
