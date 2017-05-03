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

import model.Reservation;
import model.Vol;

/**
 * @author ajc
 *
 */
public class VolDaoSql implements VolDao {

	@Override
	public List<Vol> findAll() {
		// TODO Auto-generated method stub
		List<Vol> listeVols = new ArrayList<>();

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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vol");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				Vol vol = new Vol();
				// appel des mutateurs
				vol.setIdVol(resultSet.getInt("idVol"));
				vol.setDateDepart(resultSet.getDate("dateDepart"));
				vol.setDateArrivee(resultSet.getDate("dateArrivee"));
				vol.setHeureDepart(resultSet.getTime("heureDepart"));
				vol.setHeureArrivee(resultSet.getTime("heureArrivee"));

				// j'ajoute l'objet passager ainsi muté à la liste des passagers
				listeVols.add(vol);
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

		return listeVols;

		// return null;
	}

	@Override
	public Vol findById(Integer id) {
		// TODO Auto-generated method stub
		Vol vol = null;
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vol WHERE idVol = " + id);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				vol = new Vol();
				// appel des mutateurs
				vol.setIdVol(resultSet.getInt("idVol"));
				vol.setDateDepart(resultSet.getDate("dateDepart"));
				vol.setDateArrivee(resultSet.getDate("dateArrivee"));
				vol.setHeureDepart(resultSet.getTime("heureDepart"));
				vol.setHeureArrivee(resultSet.getTime("heureArrivee"));

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
		return vol;
	}

	@Override
	public List<Vol> findByResa(Reservation reservation) {
		// Initialiser ma liste d'objets métier
		List<Vol> listeVolByResa = new ArrayList<>();
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vol WHERE idVol = " + reservation.getIdRes());

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				Vol volpass = new Vol();
				// appel des mutateurs
				volpass.setIdVol(resultSet.getInt("idVol"));
				volpass.setDateDepart(resultSet.getDate("dateDepart"));
				volpass.setDateArrivee(resultSet.getDate("dateArrivee"));
				volpass.setHeureDepart(resultSet.getTime("heureDepart"));
				volpass.setHeureArrivee(resultSet.getTime("heureArrivee"));
				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
				listeVolByResa.add(volpass);
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
		// Je retourne la liste des passagers de la BDDonnéys
		return listeVolByResa;
	}

}
