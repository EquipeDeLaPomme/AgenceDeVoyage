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
import model.ClientMoral;
import model.ClientPhysique;;

public class ClientMoralDaoSql implements ClientMoralDao{
	@Override
    public List<ClientMoral> findAll()
    {
        // Initialiser ma liste 
        List<ClientMoral> listeClientMoral = new ArrayList<>();
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
                    .executeQuery("SELECT * FROM client WHERE siret IS NOT NULL");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet 
            	ClientMoral clientMoral = new ClientMoral();
                // appel des mutateurs
            	
                clientMoral.setSiret(resultSet.getString("siret"));
                clientMoral.setNom(resultSet.getString("nom"));
                clientMoral.setId(resultSet.getInt("idClient"));
                clientMoral.setNumeroTel(resultSet.getString("numTel"));
                clientMoral.setNumeroFax(resultSet.getString("numFax"));
                clientMoral.setEmail(resultSet.getString("eMail"));
                
                
                
                listeClientMoral.add(clientMoral);
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
        return listeClientMoral;
    }

	@Override
	public ClientMoral findById(Integer id) {
		// TODO Auto-generated method stub
		
		ClientMoral clientMoral = null;
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
	                    .executeQuery("SELECT * FROM client WHERE idClient = " + id + " AND siret is Not NULL");
	            if (resultSet.next())
	            {
	                
	                clientMoral = new ClientMoral();
	                
	                clientMoral.setId(resultSet.getInt("idClient"));
	                clientMoral.setSiret(resultSet.getString("siret"));
	                clientMoral.setNom(resultSet.getString("nom"));
	                
	                clientMoral.setNumeroTel(resultSet.getString("numTel"));
	                clientMoral.setNumeroFax(resultSet.getString("numFax"));
	                clientMoral.setEmail(resultSet.getString("eMail"));
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
	        return clientMoral;
		 	
		
		
	}
}

