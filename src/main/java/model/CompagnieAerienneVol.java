/**
 * 
 */
package model;

/**
 * @author ajc
 *
 */
public class CompagnieAerienneVol {

	private String numero;
	private Ouverture ouverture;
	private Vol vol;
	
	public CompagnieAerienneVol()
	{
		
	}
	
	public CompagnieAerienneVol (String num){
		this.numero = num;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Ouverture getOuverture() {
		return ouverture;
	}

	public void setOuverture(Ouverture ouverture) {
		this.ouverture = ouverture;
	}
	
	  public void setVol(Vol vol)
	    {
	        this.vol = vol;
	    }
	    
	    public Vol getVol()
	    {
	        return vol;
	    }

	
}
