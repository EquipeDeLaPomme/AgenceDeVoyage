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
	
}
