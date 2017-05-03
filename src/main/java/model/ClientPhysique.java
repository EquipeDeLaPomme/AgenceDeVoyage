package model;

public class ClientPhysique extends Client {
	private String prenom;
	
	public ClientPhysique(String prenom, Integer id, String nom, String numeroTel, String numeroFax, String email){
		super(id, nom, numeroTel, numeroFax, email);
		this.prenom=prenom;
		
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
