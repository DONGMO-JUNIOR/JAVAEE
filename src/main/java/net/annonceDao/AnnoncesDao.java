package net.annonceDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.annonces.Annonces;

public class AnnoncesDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/annonces";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_ANNONCE_SQL = "INSERT INTO annonces (titre, categorie, contenu) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_ANNONCES_SQL = "SELECT * FROM annonces;";
    private static final String DELETE_ANNONCE_SQL = "DELETE FROM annonces WHERE id = ?;";
    private static final String UPDATE_ANNONCE_SQL = "UPDATE annonces SET titre = ?, categorie = ?, contenu = ? WHERE id = ?;";
    private static final String SELECT_ANNONCE_BY_ID = "SELECT * FROM annonces WHERE id=?;";

    public AnnoncesDao() {}

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public void insertAnnonce(Annonces annonce) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANNONCE_SQL)) {
            preparedStatement.setString(1, annonce.getTitre());
            preparedStatement.setString(2, annonce.getCategorie());
            preparedStatement.setString(3, annonce.getContenu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception during insert: " + e.getMessage());
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
            System.out.println("SQL Exception during delete: " + e.getMessage());
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
                Annonces annonce = new Annonces(id, titre, categorie, contenu);
                annonces.add(annonce);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception during getAllAnnonces: " + e.getMessage());
            e.printStackTrace();
        }
        return annonces;
    }
  
}