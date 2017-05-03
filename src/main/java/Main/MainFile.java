package Main;

import java.util.List;

import dao.AdresseDao;
import dao.AdresseDaoFile;
import dao.PassagerDao;
import dao.PassagerDaoFile;
import dao.ReservationDao;
import dao.ReservationDaoFile;
import model.Adresse;
import model.Passager;
import model.Reservation;

public class MainFile
{

    public static void main(String[] args)
    {
        AdresseDao adresseDao = new AdresseDaoFile();
        List<Adresse> adresses = adresseDao.findAll();
        Adresse adresse = adresseDao.findById(2);

        PassagerDao passagerDao = new PassagerDaoFile();
        List<Passager> passagers = passagerDao.findAll();
        Passager passager = passagerDao.findById(1);

        ReservationDao reservationDao = new ReservationDaoFile();
        List<Reservation> reservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(2);
        // Recherche par passager
        List<Reservation> reservationsPassager = reservationDao.findByPassager(passager);
    }

}
