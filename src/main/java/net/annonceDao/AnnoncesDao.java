package net.annonceDao;



import net.annonces.Annonces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

public class AnnoncesDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/annonces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_ANNONCE_SQL = "INSERT INTO annonces (titre, categorie, contenu, startDate, endDate) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_ANNONCES_SQL = "SELECT * FROM annonces;";
    private static final String DELETE_ANNONCE_SQL = "DELETE FROM annonces WHERE id = ?;";
    private static final String UPDATE_ANNONCE_SQL = "UPDATE annonces SET titre = ?, categorie = ?, contenu = ?, startDate = ?, endDate = ? WHERE id = ?;";
    private static final String SELECT_ANNONCE_BY_ID = "SELECT * FROM annonces WHERE id=?;";
    private static final String SELECT_USER_SQL = "SELECT * FROM user WHERE email = ? AND password = ?;";
    private static final String SELECT_PHOTO_SQL = "SELECT photo FROM user WHERE email = ?";

    
    public AnnoncesDao() {}

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertAnnonce(Annonces annonce) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANNONCE_SQL)) {
            System.out.println("Inserting: " + annonce.getTitre() + ", " + annonce.getCategorie() + ", " + annonce.getContenu() + ", " + annonce.getStartDate() + ", " + annonce.getEndDate());
            preparedStatement.setString(1, annonce.getTitre());
            preparedStatement.setString(2, annonce.getCategorie());
            preparedStatement.setString(3, annonce.getContenu());
            preparedStatement.setDate(4, annonce.getStartDate());
            preparedStatement.setDate(5, annonce.getEndDate());
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteAnnonce(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANNONCE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public List<Annonces> getAllAnnonces() {
        List<Annonces> annonces = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ANNONCES_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titre = resultSet.getString("titre");
                String categorie = resultSet.getString("categorie");
                String contenu = resultSet.getString("contenu");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                Annonces annonce = new Annonces(id, titre, categorie, contenu, startDate, endDate);
                annonces.add(annonce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonces;
    }

    public Annonces selectAnnonceById(int id) {
        Annonces annonce = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANNONCE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String titre = rs.getString("titre");
                String categorie = rs.getString("categorie");
                String contenu = rs.getString("contenu");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                annonce = new Annonces(id, titre, categorie, contenu, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonce;
    }

    public boolean updateAnnonce(Annonces annonce) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ANNONCE_SQL)) {
            statement.setString(1, annonce.getTitre());
            statement.setString(2, annonce.getCategorie());
            statement.setString(3, annonce.getContenu());
            statement.setDate(4, annonce.getStartDate());
            statement.setDate(5, annonce.getEndDate());
            statement.setInt(6, annonce.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean validateUser(String email, String password) {
        boolean isValid = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println("Executing query with email: " + email + " and password: " + password);
            ResultSet rs = preparedStatement.executeQuery();
            isValid = rs.next();
            System.out.println("Query executed, isValid: " + isValid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

   

    public Blob getUserPhoto(String email) {
        Blob photo = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHOTO_SQL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                photo = (Blob) rs.getBlob("photo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return photo;
    }
}
