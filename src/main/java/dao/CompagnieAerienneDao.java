package dao;

import java.util.List;

import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.Reservation;
import model.Vol;

public interface CompagnieAerienneDao extends Dao<CompagnieAerienne, Integer> 
{
	public List<CompagnieAerienneVol> findByVol(Vol vol);

}
