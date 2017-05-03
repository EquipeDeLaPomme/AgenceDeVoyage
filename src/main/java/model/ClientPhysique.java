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
	
	
	@Override
	public void afficherInfos(){
		System.out.println("Les informations du client sont : ");
		System.out.println("\t - identification : " + this.getId());
		System.out.println("\t - nom : " + this.getNom());
		System.out.println("\t - prénom : " + this.prenom);
		System.out.println("\t - tel: " + this.getNumeroTel());
		System.out.println("\t - fax: " + this.getNumeroFax());
		System.out.println("\t - email: "+ this.getEmail());
		System.out.println("");
	}
}
