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
import model.ClientPhysique;;

public class ClientPhysiqueDaoSql implements ClientPhysiqueDao {
	
	@Override
    public List<ClientPhysique> findAll()
    {
        // Initialiser ma liste d'adresses
        List<ClientPhysique> listeClientPhysique = new ArrayList<>();
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
                    .executeQuery("SELECT * FROM client WHERE siret IS NULL");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet adresse
            	ClientPhysique clientPhysique = new ClientPhysique();
                // appel des mutateurs
            	
                clientPhysique.setPrenom(resultSet.getString("prenom"));
                clientPhysique.setNom(resultSet.getString("nom"));
                clientPhysique.setId(resultSet.getInt("idClient"));
                clientPhysique.setNumeroTel(resultSet.getString("numTel"));
                clientPhysique.setNumeroFax(resultSet.getString("numFax"));
                clientPhysique.setEmail(resultSet.getString("eMail"));
                
                
                // j'ajoute l'objet adresse ainsi muté à la liste des adresses
                listeClientPhysique.add(clientPhysique);
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
        return listeClientPhysique;
    }

	@Override
	public ClientPhysique findById(Integer id) {
		// TODO Auto-generated method stub
		
		ClientPhysique clientPhysique = null;
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
	                    .executeQuery("SELECT * FROM client WHERE idClient = " + id + " AND siret is NULL");
	            if (resultSet.next())
	            {
	                
	                clientPhysique = new ClientPhysique();
	                
	                clientPhysique.setId(resultSet.getInt("idClient"));
	                
	            }
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
	        // Je retourne l'adresse
	        return clientPhysique;
		 	
		
		
	}
}
