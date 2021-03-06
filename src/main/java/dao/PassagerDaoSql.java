/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Passager;

/**
 * @author Seme
 */
public class PassagerDaoSql implements PassagerDao
{
    AdresseDao adresseDao = new AdresseDaoSql();

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Passager> findAll()
    {
        // Initialiser ma liste de passagers
        List<Passager> listePassagers = new ArrayList<>();
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM passager");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet passager
                Passager passager = new Passager();
                // appel des mutateurs
                passager.setIdPas(resultSet.getInt("idPassager"));
                passager.setNom(resultSet.getString("nom"));
                passager.setPrenom(resultSet.getString("prenom"));
                passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
                // j'ajoute l'objet passager ainsi muté à la liste des passagers
                listePassagers.add(passager);
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des passagers de la BDDonnéys
        return listePassagers;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */
    @Override
    public Passager findById(Integer id)
    {
        // Initialiser mon passager
        Passager passager = null;
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM passager WHERE idPassager = " + id);

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
                passager = new Passager();
                // appel des mutateurs
                passager.setIdPas(resultSet.getInt("idPassager"));
                passager.setNom(resultSet.getString("nom"));
                passager.setPrenom(resultSet.getString("prenom"));
                passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne l'objet métier
        return passager;
    }

}
