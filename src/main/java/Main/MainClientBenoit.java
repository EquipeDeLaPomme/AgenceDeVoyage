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
import model.Adresse;
import model.ClientPhysique;
import model.ClientMoral;
import model.Passager;
import model.Reservation;

import model.Client;
import dao.ClientPhysiqueDao;
import dao.ClientPhysiqueDaoSql;
import dao.ClientMoralDao;
import dao.ClientMoralDaoSql;
//import dao.PassagerDao;
//import dao.PassagerDaoSql;
//import dao.ReservationDao;
//import dao.ReservationDaoSql;
/**
 * @author ajc
 *
 */
public class MainClientBenoit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// J'instancie le dao SQL 
        ClientPhysiqueDaoSql clientPhysiqueDao = new ClientPhysiqueDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<ClientPhysique> listeClientPhysique = clientPhysiqueDao.findAll();
        ClientPhysique clientPhysique = clientPhysiqueDao.findById(21);
        
        ClientMoralDaoSql clientMoralDao = new ClientMoralDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<ClientMoral> listeClientMoral = clientMoralDao.findAll();
        ClientMoral clientMoral = clientMoralDao.findById(12);
        
        ClientMoral clientMoral2 = new ClientMoral("2541564", 2, "nom", "numeroTel", "numeroFax", "email");
        
        
        
	}

}
