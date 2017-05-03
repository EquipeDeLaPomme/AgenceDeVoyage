/** *  */package Main;import java.util.List;import dao.AdresseDao;import dao.AdresseDaoSql;import dao.LoginDAO;import dao.LoginDaoSql;import dao.PassagerDao;import dao.PassagerDaoSql;import dao.ReservationDao;import dao.ReservationDaoSql;import dao.VolDao;import dao.VolDaoSql;import model.Adresse;import model.Login;import model.Passager;import model.Reservation;import model.Vol;/** *  * Classe principale de test de récupération de données via la BDD *  *  *  * @author Seme *  */public class MainDB {	/**	 * 	 * Méthode principale qui va faire appel à toutes les méthodes de	 * 	 * récupération de mes DAO SQL : - findAll - findById	 * 	 * 	 * 	 * @param args	 * 	 *            Arguments passés en paramètres d'entrée	 * 	 */	public static void main(String[] args) {		/**		 * 		 * Permet les tests pour la classe adresse		 * 		 */		// J'instancie le dao SQL des adresses		AdresseDao adresseDao = new AdresseDaoSql();		// J'appelle la méthode findAll pour récupérer toutes les adresses		// stockées en BDD		List<Adresse> listeAdresses = adresseDao.findAll();		Adresse adresse = adresseDao.findById(1);		/**		 * 		 * Permet les tests pour la classe passager		 * 		 */		// J'instancie le dao SQL de l'objet métier à récupérer		PassagerDao passagerDao = new PassagerDaoSql();		// J'appelle la méthode findAll pour récupérer tous les BO de ce type de		// la BDD		List<Passager> listePassagers = passagerDao.findAll();		Passager passager = passagerDao.findById(1);		/**		 * 		 * Permet les tests pour la classe Réservation		 * 		 */		// J'instancie le dao SQL de l'objet métier à récupérer		ReservationDao reservationDao = new ReservationDaoSql();		// J'appelle la méthode findAll pour récupérer tous les BO de ce type de		// la BDD		List<Reservation> listeReservations = reservationDao.findAll();		Reservation reservation = reservationDao.findById(10);		listeReservations = reservationDao.findByPassager(passager);				/**		 * 		 * Permet les tests pour la classe Login		 * 		 */		// J'instancie le dao SQL des login		LoginDAO loginDao = new LoginDaoSql();		// J'appelle la méthode findAll pour récupérer tous les logins stockées		// en BDD		List<Login> listeLogin = loginDao.findAll();		// Affiche un exemple		listeLogin.get(1).afficherInfos();		// instanciation de l'objet login de classe Login		Login login = loginDao.findById(1);		// Affiche les informations de login		login.afficherInfos();		/**		 * 		 * Permet les tests pour la classe adresse		 * 		 */		// J'instancie le dao SQL des login		VolDao volDao = new VolDaoSql();		// J'appelle la méthode findAll pour récupérer tous les logins stockées		// en BDD		List<Vol> listeVols = volDao.findAll();		Vol vol = volDao.findById(21);		// Affiche les informations de login		vol.afficherInfos();	}}