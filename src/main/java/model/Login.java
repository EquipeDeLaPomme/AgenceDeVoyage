/**
 * 
 */
package model;

/**
 * @author ajc
 *
 */
public class Login {
	
	private Integer idLogin;
	private String login;
	private String motDePasse;
	private Boolean admin;
	
	
	
	
	
	/**
	 * @param idLogin
	 * @param login
	 * @param motDePasse
	 * @param admin
	 */
	public Login(Integer idLogin, String login, String motDePasse, Boolean admin) {
		super();
		this.idLogin = idLogin;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	
	public Login(){
		
	}
	
	
	
	public void afficherInfos(){
		System.out.println("Les informations du Login sont : ");
		System.out.println("\t - identifiant : " + idLogin);
		System.out.println("\t - login : " + login);
		System.out.println("\t - mot de passe : " + motDePasse);
		if (admin == true) {
			System.out.println("\t - admin : oui");
		} else {
			System.out.println("\t - admin : non");
		}
		System.out.println("");
	}

	
	
	
	
	
	
	
	/**
	 * @return the idLogin
	 */
	public Integer getIdLogin() {
		return idLogin;
	}

	/**
	 * @param idLogin the idLogin to set
	 */
	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
	
	
	
	
	
	

}
