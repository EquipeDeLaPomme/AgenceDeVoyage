package Main;

import java.util.List;

import dao.CompagnieAerienneDao;
import dao.CompagnieAerienneDaoSql;
import dao.VolDao;
import dao.VolDaoSql;
import model.CompagnieAerienne;
import model.Vol;

public class MainClement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VolDao volDao = new VolDaoSql();
		List<Vol> listeVols = volDao.findAll();
		Vol vol = volDao.findById(21);
		
		CompagnieAerienneDao compagnieDao = new CompagnieAerienneDaoSql();
		List<CompagnieAerienne> listecompagnies = compagnieDao.findAll();
		CompagnieAerienne compagnie = compagnieDao.findById(1);
		
	}

}
