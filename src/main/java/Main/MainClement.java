package Main;

import java.util.List;

import dao.CompagnieAerienneDao;
import dao.CompagnieAerienneDaoSql;
import dao.VolDao;
import dao.VolDaoSql;
import dao.ReservationDao;
import dao.ReservationDaoSql;
import model.CompagnieAerienne;
import model.Reservation;
import model.Vol;
import model.Reservation;

public class MainClement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservationDao reservationDao = new ReservationDaoSql();
		List<Reservation> listeReservations = reservationDao.findAll();
		Reservation reservation = reservationDao.findById(21);
		
		VolDao volDao = new VolDaoSql();
		List<Vol> listeVols = volDao.findAll();
		Vol vol = volDao.findById(21);
		listeVols = volDao.findByResa(reservation);
		System.out.println(listeVols);
		
		CompagnieAerienneDao compagnieDao = new CompagnieAerienneDaoSql();
		List<CompagnieAerienne> listecompagnies = compagnieDao.findAll();
		CompagnieAerienne compagnie = compagnieDao.findById(1);
		
		
	}

}
