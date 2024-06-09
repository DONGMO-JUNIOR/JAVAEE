

import net.annonceDao.AnnoncesDao;

public class TestConnexionBD {
    public static void main(String[] args) {
        AnnoncesDao annoncesDao = new AnnoncesDao();

        try {
            if (annoncesDao.getConnection() != null) {
                System.out.println("Connexion à la base de données réussie !");
            } else {
                System.out.println("La connexion à la base de données a échoué.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la tentative de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
