package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Adresse;
import model.Client;

public abstract class ClientDaoSql implements ClientDao {
	@Override
    public List<Client> findAll()
    {
        // Initialiser ma liste d'adresses
        List<Client> listeClient = new ArrayList<>();
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
                    .executeQuery("SELECT * FROM client");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet adresse
                Client client = new Client();
                // appel des mutateurs
                client.setId(resultSet.getInt("idClient"));
                client.setEmail(resultSet.getString("eMail"));
                client.setNom(resultSet.getString("nom"));
                client.setNumeroTel(resultSet.getString("numTel"));
                client.setNumeroFax(resultSet.getString("numFax"));
                //client.setNumeroTel(resultSet.getString("numTel")); siret
                //client.setNumeroTel(resultSet.getString("numTel")); prenoms
                listeClient.add(client);
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
        // Je retourne la liste des adresses de la BDDonnéys
        return listeClient;
    }

}
