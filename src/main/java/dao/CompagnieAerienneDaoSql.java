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

import model.CompagnieAerienne;

/**
 * @author ajc
 *
 */
public class CompagnieAerienneDaoSql implements CompagnieAerienneDao{
	@Override
	public List<CompagnieAerienne> findAll() {
		// TODO Auto-generated method stub
		List<CompagnieAerienne> listeCompagnies = new ArrayList<>();

		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencedevoyage", "user1",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM compagnie_aerienne");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				CompagnieAerienne compagnie = new CompagnieAerienne();
				// appel des mutateurs
				compagnie.setId(resultSet.getInt("id"));
				compagnie.setNom(resultSet.getString("nom"));


				// j'ajoute l'objet passager ainsi muté à la liste des passagers
				listeCompagnies.add(compagnie);
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}

		return listeCompagnies;

		// return null;
	}

	@Override
	public CompagnieAerienne findById(Integer id) {
		// TODO Auto-generated method stub
		CompagnieAerienne compagnie = null;
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencedevoyage", "user1",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM compagnie_aerienne WHERE id = " + id);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				compagnie = new CompagnieAerienne();
				// appel des mutateurs
				compagnie.setId(resultSet.getInt("id"));
				compagnie.setNom(resultSet.getString("nom"));

			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne l'objet métier
		return compagnie;
	}
}
