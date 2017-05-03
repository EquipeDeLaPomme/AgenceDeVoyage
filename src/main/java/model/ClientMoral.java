package model;

public class ClientMoral extends Client {
	private String siret;
	
	public ClientMoral(String siret, Integer id, String nom, String numeroTel, String numeroFax, String email){
		super(id, nom, numeroTel, numeroFax, email);
		this.siret=siret;
		
	}
	public ClientMoral(){
		super();
	}
	
	public String getSiret() {
		return siret;
	}
	
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	public void afficherInfos(){
		System.out.println("Les informations du client sont : ");
		System.out.println("\t - identification : " + this.getId());
		System.out.println("\t - nom : " + this.getNom());
		System.out.println("\t - numéro de Siret : " + this.siret);
		System.out.println("\t - tel: " + this.getNumeroTel());
		System.out.println("\t - fax: " + this.getNumeroFax());
		System.out.println("\t - email: "+ this.getEmail());
		System.out.println("");
	}
	
}
