package Main;

import java.util.List;

import dao.CompagnieAerienneDao;
import dao.CompagnieAerienneDaoSql;
import dao.PassagerDao;
import dao.PassagerDaoSql;
import dao.ReservationDao;
import dao.ReservationDaoSql;
import dao.VolDao;
import dao.VolDaoSql;
import model.CompagnieAerienne;
import model.Passager;
import model.Reservation;
import model.Vol;

public class MainClement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservationDao reservationDao = new ReservationDaoSql();
		List<Reservation> listeReservations = reservationDao.findAll();
		Reservation reservationP = reservationDao.findById(21);
		
		PassagerDao passagerDao = new PassagerDaoSql();

		// J'appelle la méthode findAll pour récupérer tous les BO de ce type de
		// la BDD

		List<Passager> listePassagers = passagerDao.findAll();

		Passager passager = passagerDao.findById(1);
		
		
		VolDao volDao = new VolDaoSql();
		List<Vol> listeVols = volDao.findAll();
		Vol vol = volDao.findById(30);
		listeReservations = reservationDao.findByVol(vol);
		listeReservations = reservationDao.findByPassager(passager);
		
		System.out.println(listeReservations);
		
		CompagnieAerienneDao compagnieDao = new CompagnieAerienneDaoSql();
		List<CompagnieAerienne> listecompagnies = compagnieDao.findAll();
		CompagnieAerienne compagnie = compagnieDao.findById(1);
		
		
	}

}
