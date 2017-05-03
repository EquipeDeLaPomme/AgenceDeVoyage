package Main;

import java.util.List;

import dao.AdresseDao;
import dao.AdresseDaoSql;
import dao.LoginDAO;
import dao.LoginDaoSql;
import model.Adresse;
import model.Login;

public class MainDamien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/**
		 * Permet le test des classes concernant Login
		 */
		// J'instancie le dao SQL des adresses
        LoginDAO loginDao = new LoginDaoSql();
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<Login> listeLogin = loginDao.findAll();
		// Affiche un exemple
        listeLogin.get(1).afficherInfos();
		
        // instanciation de l'objet login de classe Login
        Login login = loginDao.findById(1);
        // Affiche les informations de login
        login.afficherInfos();

	}

}
