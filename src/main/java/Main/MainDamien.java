/**

 * 

 */

package Main;

import java.util.List;
import dao.AdresseDao;
import dao.AdresseDaoSql;
import dao.ClientMoralDao;
import dao.ClientMoralDaoSql;
import dao.ClientPhysiqueDao;
import dao.ClientPhysiqueDaoSql;
import dao.LoginDAO;
import dao.LoginDaoSql;
import dao.PassagerDao;
import dao.PassagerDaoSql;
import dao.ReservationDao;
import dao.ReservationDaoSql;
import dao.VolDao;
import dao.VolDaoSql;
import model.Adresse;
import model.ClientMoral;
import model.ClientPhysique;
import model.Login;
import model.Passager;
import model.Reservation;
import model.Vol;

/**
 * 
 * Classe principale de test de récupération de données via la BDD
 * 
 * 
 * 
 * @author Seme
 * 
 */

public class MainDB {

	/**
	 * 
	 * Méthode principale qui va faire appel à toutes les méthodes de
	 * 
	 * récupération de mes DAO SQL : - findAll - findById
	 * 
	 * 
	 * 
	 * @param args
	 * 
	 *            Arguments passés en paramètres d'entrée
	 * 
	 */

	public static void main(String[] args) {

		
		try {
			/**
			 * 
			 * Permet les tests pour la classe adresse
			 * 
			 */
			// J'instancie le dao SQL des adresses
			AdresseDao adresseDao = new AdresseDaoSql();
			// J'appelle la méthode findAll pour récupérer toutes les adresses
			// stockées en BDD
			List<Adresse> listeAdresses = adresseDao.findAll();
			// affiche les informations d'une adresse
			listeAdresses.get(1).afficherInfos();
			
			// J'instancie l'objet adresse
			Adresse adresse = adresseDao.findById(1);
			// affiche les informations de adresse
			adresse.afficherInfos();
	
			
			
			
			/**
			 * 
			 * Permet les tests pour la classe passager
			 * 
			 */
			// J'instancie le dao SQL de l'objet métier à récupérer
			PassagerDao passagerDao = new PassagerDaoSql();
			// J'appelle la méthode findAll pour récupérer tous les BO de ce type de
			// la BDD
			List<Passager> listePassagers = passagerDao.findAll();
			// affiche les informations d'un des passagers
			listePassagers.get(1).afficherInfos();
			
			// J'instancie l'objet adresse
			Passager passager = passagerDao.findById(1);
			// affiche les informations du passager
			passager.afficherInfos();
	
			
			
			
			
			/**
			 * 
			 * Permet les tests pour la classe Réservation
			 * 
			 */
			// J'instancie le dao SQL de l'objet métier à récupérer
			ReservationDao reservationDao = new ReservationDaoSql();
			// J'appelle la méthode findAll pour récupérer tous les BO de ce type de
			// la BDD
			List<Reservation> listeReservations = reservationDao.findAll();
			// affiche les informations d'une des réservations
			listeReservations.get(1).afficherInfos();
			
			// J'instancie l'objet adresse
			Reservation reservation = reservationDao.findById(40);
			// affiche les informations de la réservation
			reservation.afficherInfos();
			
			
			// 
			listeReservations = reservationDao.findByPassager(passager);
			// affiche les informations d'une réservation
			System.out.println("Le numéro de la réservation est : " + listeReservations.toString());
	        System.out.println("");

			
			
			/**
			 * 
			 * Permet les tests pour la classe ClientPhysique
			 * 
			 */
			// J'instancie le dao SQL 
	        ClientPhysiqueDao clientPhysiqueDao = new ClientPhysiqueDaoSql();
	        // J'appelle la méthode findAll pour récupérer tous les clientsPhysiques
	        // stockées en BDD
	        List<ClientPhysique> listeClientPhysique = clientPhysiqueDao.findAll();
	        // Affiche les informations du client physique
	        listeClientPhysique.get(2).afficherInfos();
	        
	        // J'instancie l'objet clientPhysique de classe ClientPhysique
	        ClientPhysique clientPhysique = clientPhysiqueDao.findById(21);
	        // Affichage des informations du client physique sélectionné
	        clientPhysique.afficherInfos();
	        
	        
	        
	        
			/**
			 * 
			 * Permet les tests pour la classe ClientPhysique
			 * 
			 */
	        // Instanciation d'un clientMoral
	        ClientMoral clientMoral2 = new ClientMoral("2541564", 2, "nomEntreprise", "0554842536", "0563582548", "contact@nomEntreprise.com");
	        // Affiche les informations de clientMoral2
	        clientMoral2.afficherInfos();
	        
	        // J'appelle la méthode findAll pour récupérer tous les clientsMoral
	        // stockées en BDD
	        ClientMoralDao clientMoralDao = new ClientMoralDaoSql();
	        // J'appelle la méthode findAll pour récupérer toutes les adresses
	        // stockées en BDD
	        List<ClientMoral> listeClientMoral = clientMoralDao.findAll();
	        // affichage des informations
	        listeClientMoral.get(0).afficherInfos();
	        
	        
	        ClientMoral clientMoral = clientMoralDao.findById(30);
	        // Afficahge des informations du client 30
	        clientMoral.afficherInfos();
	        
	        
			
			
			/**
			 * 
			 * Permet les tests pour la classe Login
			 * 
			 */
			// J'instancie le dao SQL des login
			LoginDAO loginDao = new LoginDaoSql();
			// J'appelle la méthode findAll pour récupérer tous les logins stockées
			// en BDD
			List<Login> listeLogin = loginDao.findAll();
			// Affiche un exemple
			listeLogin.get(1).afficherInfos();
			
			// instanciation de l'objet login de classe Login
			Login login = loginDao.findById(1);
			// Affiche les informations de login
			login.afficherInfos();
	
			
			
			
			/**
			 * 
			 * Permet les tests pour la classe adresse
			 * 
			 */
			// J'instancie le dao SQL des login
			VolDao volDao = new VolDaoSql();
			// J'appelle la méthode findAll pour récupérer tous les logins stockées
			// en BDD
			List<Vol> listeVols = volDao.findAll();
			Vol vol = volDao.findById(21);
			// Affiche les informations de login
			vol.afficherInfos();
			
			
			
			
			
		// Permet de récupérer les erreurs NullPointerException
		} catch (NullPointerException e) {
			System.err.println("Erreur dans la lecture des données. Verifiez que vous avez bien entré les bons identifiants");
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Une erreur s'est produite sur les données !");
			e.printStackTrace();
		}
		
		

	}

}
