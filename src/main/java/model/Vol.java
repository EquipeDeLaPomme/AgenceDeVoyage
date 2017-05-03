package model;

import java.sql.Time;
import java.util.Date;

public class Vol {

	public int idVol;
	public Date dateDepart;
	public Date dateArrivee;
	public Time heureDepart;
	public Time heureArrivee;
	
	
	

	public Vol() {

	}
	

	
    /**
     * Méthode permettant d'afficher les informations de la réservation
     */
	public void afficherInfos() {
		System.out.println("Les informations du vol sont : ");
		System.out.println("\t - identifiant : " + idVol);
		System.out.println("\t - date de départ : " + dateDepart);
		System.out.println("\t - heure de départ : " + heureDepart);
		System.out.println("\t - date d'arrivée : " + dateArrivee);
		System.out.println("\t - heure d'arrivée : " + heureArrivee);
		System.out.println("");
	}
	
	
	
	

	public Vol(int idVol) {
		this.idVol = idVol;
	}

	public int getIdVol() {
		return idVol;
	}

	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
    @Override
    public String toString(){
		return "Vol " + this.idVol + " : Départ [" + dateDepart + " - " + heureDepart + "] Arrivée ["
				 + dateArrivee + " - " + heureArrivee + "]";
	}
	
}
