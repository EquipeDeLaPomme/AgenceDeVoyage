/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ajc
 *
 */
public abstract class Client {
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;
	private int id;
	
	public Client (Integer id, String nom, String numeroTel, String numeroFax, String email){
		this.nom=nom;
		this.numeroTel=numeroTel;
		this.numeroFax=numeroFax;
		this.email=email;
		this.id=id;
	}	
	
	
	public Client (){
	}
	
	public void afficherInfos(){
		System.out.println("Les informations du client sont : ");
		System.out.println("\t - identification : " + this.id);
		System.out.println("\t - nom : " + this.nom);
		System.out.println("\t - tel: " + this.numeroTel);
		System.out.println("\t - fax: " + this.numeroFax);
		System.out.println("\t - email: "+ this.email);
		System.out.println("");
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public String getNumeroFax() {
		return numeroFax;
	}
	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
