package dao;

import java.util.List;

import model.Passager;
import model.Reservation;
import model.Vol;

public interface ReservationDao extends Dao<Reservation, Integer>
{
    /**
     * Retourne la liste des réservations en fonction d'un passager
     * 
     * @param passager
     *            Le passager
     * @return Liste des réservations en fonction du passager passé en paramètre
     */
    public List<Reservation> findByPassager(Passager passager);
    public List<Reservation> findByVol(Vol vol);
}
