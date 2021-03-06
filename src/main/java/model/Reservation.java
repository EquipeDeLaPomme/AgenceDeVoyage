package model;

import java.util.Date;

/**
 * Réservation d'un vol pour un passager effectuée par un client
 * 
 * @author Seme
 */
public class Reservation
{

    /**
     * Id de la réservation
     */
    private int idRes;
    /**
     * Date de la réservation
     */
    private Date date;
    /**
     * Numéro de la réservation
     */
    private String numero;
    /**
     * Etat de la réservation (annulée ou confirmée)
     */
    private EtatReservation etat;
    /**
     * La référence du passager
     */
    private Passager passager;
    private Vol vol;

    /**
     * Constructeur
     * 
     * @param idRes
     *            Identifiant technique de la réservation
     */
    public Reservation(int idRes)
    {
        this.idRes = idRes;
    }

    /**
     * 
     */
    public Reservation()
    {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * Méthode permettant d'afficher les informations de la réservation
     */
	public void afficherInfos() {
		System.out.println("Les informations de la réservations sont : ");
		System.out.println("\t - identifiant : " + idRes);
		System.out.println("\t - date : " + date);
		System.out.println("\t - numero " + numero);
		System.out.println("\t - etat : " + etat);
		System.out.println("");
	}

    /**
     * @return the idRes
     */
    public int getIdRes()
    {
        return idRes;
    }

    /**
     * @param idRes
     *            the idRes to set
     */
    public void setIdRes(int idRes)
    {
        this.idRes = idRes;
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * @param numero
     *            the numero to set
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * @return the etat
     */
    public EtatReservation getEtat()
    {
        return etat;
    }

    /**
     * @param etat
     *            the etat to set
     */
    public void setEtat(EtatReservation etat)
    {
        this.etat = etat;
    }

    /**
     * @return the passager
     */
    public Passager getPassager()
    {
        return passager;
    }

    /**
     * @param passager
     *            the passager to set
     */
    public void setVol(Vol vol)
    {
        this.vol = vol;
    }
    
    public Vol getVol()
    {
        return vol;
    }

    /**
     * @param passager
     *            the passager to set
     */
    public void setPassager(Passager passager)
    {
        this.passager = passager;
    }
    

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        String reponse = "Reservation : " + this.numero;

        return reponse;
    }

}
