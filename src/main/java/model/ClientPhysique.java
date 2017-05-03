package model;

public class ClientPhysique extends Client {
	private String prenom;
	
	public ClientPhysique(String prenom, Integer id, String nom, String numeroTel, String numeroFax, String email){
		super(id, nom, numeroTel, numeroFax, email);
		this.prenom=prenom;
		
	}
	public ClientPhysique(){
		super();
		
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void afficherClientPhysique(){
		System.out.println("Prenom et nom du Client" + this.prenom + ", "+ this.getNom() +  ".");
		
	}
}
