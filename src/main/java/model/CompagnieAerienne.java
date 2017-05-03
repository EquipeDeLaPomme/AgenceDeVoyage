/**
 * 
 */
package model;

/**
 * @author ajc
 *
 */
public class CompagnieAerienne {

		public int id;
		public String nom;
		
		public CompagnieAerienne(){
			
		}
		public CompagnieAerienne(int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		public String toString(){
			return "Compagnie " + this.nom;
		}
}
