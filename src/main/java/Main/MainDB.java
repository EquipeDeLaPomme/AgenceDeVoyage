/**
 * 
 */
package Main;

import java.util.List;

import dao.AdresseDao;
import dao.AdresseDaoSql;
import dao.PassagerDao;
import dao.PassagerDaoSql;
import dao.ReservationDao;
import dao.ReservationDaoSql;
import dao.VolDao;
import dao.VolDaoSql;
import model.Adresse;
import model.Passager;
import model.Reservation;
import model.Vol;

/**
 * Classe principale de test de récupération de données via la BDD
 * 
 * @author Seme
 */
public class MainDB {

	/**
	 * Méthode principale qui va faire appel à toutes les méthodes de
	 * récupération de mes DAO SQL : - findAll - findById
	 * 
	 * @param args
	 *            Arguments passés en paramètres d'entrée
	 */
	public static void main(String[] args) {
		// J'instancie le dao SQL des adresses
		AdresseDao adresseDao = new AdresseDaoSql();
		// J'appelle la méthode findAll pour récupérer toutes les adresses
		// stockées en BDD
		List<Adresse> listeAdresses = adresseDao.findAll();
		Adresse adresse = adresseDao.findById(1);

		// J'instancie le dao SQL de l'objet métier à récupérer
		PassagerDao passagerDao = new PassagerDaoSql();
		// J'appelle la méthode findAll pour récupérer tous les BO de ce type de
		// la BDD
		List<Passager> listePassagers = passagerDao.findAll();
		Passager passager = passagerDao.findById(1);

		// J'instancie le dao SQL de l'objet métier à récupérer
		ReservationDao reservationDao = new ReservationDaoSql();
		// J'appelle la méthode findAll pour récupérer tous les BO de ce type de
		// la BDD
		List<Reservation> listeReservations = reservationDao.findAll();
		Reservation reservation = reservationDao.findById(10);
		listeReservations = reservationDao.findByPassager(passager);

		VolDao volDao = new VolDaoSql();
		List<Vol> listeVols = volDao.findAll();
		Vol vol = volDao.findById(21);
		System.out.println(vol);
	}

}
