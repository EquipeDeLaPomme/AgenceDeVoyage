/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.EtatReservation;
import model.Ouverture;
import model.Passager;
import model.Reservation;
import model.Vol;

/**
 * @author Seme
 */
public class ReservationDaoSql implements ReservationDao
{
    PassagerDao passagerDao = new PassagerDaoSql();
    VolDao VolDao = new VolDaoSql();

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Reservation> findAll()
    {
        // Initialiser ma liste d'objets métier
        List<Reservation> listeBO = new ArrayList<>();
        // Init du format de la date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM reservation");

            /*
             * Etape 4 : Parcours des résultats
             */
            while (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
                Reservation bo = new Reservation();
                // appel des mutateurs
                bo.setIdRes(resultSet.getInt("idResa"));
                // bo.setDate(simpleDateFormat
                // .parse(resultSet.getString("dateReservation")));
                bo.setDate(resultSet.getDate("dateReservation"));
                bo.setNumero(resultSet.getString("numero"));
                bo.setEtat(EtatReservation
                        .permissiveValueOf(resultSet.getString("etat")));
                bo.setPassager(
                        passagerDao.findById(resultSet.getInt("idPassager")));
                // j'ajoute l'objet métier ainsi muté à la liste des objets
                // métier
                listeBO.add(bo);
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // catch (ParseException e)
        // {
        // System.err.println("Impossible de parser la date.");
        // e.printStackTrace();
        // }
        // Je retourne la liste des passagers de la BDDonnéys
        return listeBO;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */
    @Override
    public Reservation findById(Integer id)
    {
        // Initialiser mon bo
        Reservation bo = null;
        // Init du format de la date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM reservation WHERE idResa = " + id);

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
                bo = new Reservation();
                // appel des mutateurs
                bo.setIdRes(resultSet.getInt("idResa"));
                // bo.setDate(simpleDateFormat
                // .parse(resultSet.getString("dateReservation")));
                bo.setDate(resultSet.getDate("dateReservation"));
                bo.setNumero(resultSet.getString("numero"));
                bo.setEtat(EtatReservation
                        .permissiveValueOf(resultSet.getString("etat")));
                bo.setPassager(
                        passagerDao.findById(resultSet.getInt("idPassager")));
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // catch (ParseException e)
        // {
        // System.err.println("Impossible de parser la date.");
        // e.printStackTrace();
        // }
        // Je retourne l'objet métier
        return bo;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.ReservationDao#findByPassager(agence.model.Passager)
     */
    @Override
    public List<Reservation> findByPassager(Passager passager)

    {
        // Initialiser ma liste d'objets métier
        List<Reservation> listeBO = new ArrayList<>();
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM reservation WHERE idPassager = "
                            + passager.getIdPas());

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
                Reservation bo = new Reservation();
                // appel des mutateurs
                bo.setIdRes(resultSet.getInt("idResa"));
                bo.setDate(resultSet.getDate("dateReservation"));
                bo.setNumero(resultSet.getString("numero"));
                bo.setEtat(EtatReservation
                        .permissiveValueOf(resultSet.getString("etat")));
                bo.setPassager(passager);
                bo.setVol(
                        VolDao.findById(resultSet.getInt("idVol")));
                // j'ajoute l'objet métier ainsi muté à la liste des objets
                // métier
                listeBO.add(bo);
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des passagers de la BDDonnéys
        return listeBO;
    }

    public List<Reservation> findByVol(Vol vol) {
		// TODO Auto-generated method stub
		// Initialiser ma liste d'objets métier
        List<Reservation> listeVols = new ArrayList<>();

        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agencedevoyage", "user1", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM compagnie_aerienne_vol WHERE idCompagnie IN "
                    + "( SELECT id FROM compagnie_aerienne WHERE idVol IN "
                    + "( SELECT idVol FROM vol WHERE idVol = " + vol.getIdVol() + ")) " );

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
            	
            	Reservation bo = new Reservation();
            	
            	bo.setIdRes(resultSet.getInt("idResa"));
                bo.setDate(resultSet.getDate("dateReservation"));
                bo.setNumero(resultSet.getString("numero"));
                bo.setEtat(EtatReservation
                        .permissiveValueOf(resultSet.getString("etat")));
                bo.setVol(vol);
                bo.setPassager(
                        passagerDao.findById(resultSet.getInt("idPassager")));
                listeVols.add(bo);

                
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des passagers de la BDDonnéys
        return listeVols;
	}

}
