/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Guerin Victor
 *
 */
@Entity
@Table
@NamedQueries({ @NamedQuery(name = "getAllCarte", query = "SELECT c FROM Carte as c"),
	@NamedQuery(name = "getCarteById", query = "SELECT c FROM Carte as c WHERE c.id_carte =:id"), })
public class Carte implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
		/**
		 * 1_Les propriétés (champs, attributs)
		 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_carte;
	
	private long numCarte;
	private String typeCarte;
	private String Nomtitulaire;
	private int plafond;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="id_compte")
	private Compte compte;
	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------2_Les constructeurs------------------------------------------------------------	
		/**
		 * 2_Les constructeurs
		 */
		public Carte() {
			super();
		}
		
		public Carte(int id_carte, long numCarte, String typeCarte, String nomtitulaire, int plafond) {
			super();
			this.id_carte = id_carte;
			this.numCarte = numCarte;
			this.typeCarte = typeCarte;
			this.Nomtitulaire = nomtitulaire;
			this.plafond = plafond;
		}

		public Carte(long numCarte, String typeCarte, String nomtitulaire, int plafond) {
			super();
			this.numCarte = numCarte;
			this.typeCarte = typeCarte;
			this.Nomtitulaire = nomtitulaire;
			this.plafond = plafond;
		}

		
		
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------3_Les Getters et Setters-------------------------------------------------------
		/**
		 * 3_Les Getters et Setters
		 */
	
		public int getId_carte() {
			return id_carte;
		}

		public void setId_carte(int id_carte) {
			this.id_carte = id_carte;
		}

		public long getNumCarte() {
			return numCarte;
		}

		public void setNumCarte(long numCarte) {
			this.numCarte = numCarte;
		}

		public String getTypeCarte() {
			return typeCarte;
		}

		public void setTypeCarte(String typeCarte) {
			this.typeCarte = typeCarte;
		}

		public String getNomtitulaire() {
			return Nomtitulaire;
		}

		public void setNomtitulaire(String nomtitulaire) {
			Nomtitulaire = nomtitulaire;
		}

		public int getPlafond() {
			return plafond;
		}

		public void setPlafond(int plafond) {
			this.plafond = plafond;
		}

		public Compte getCompte() {
			return compte;
		}

		public void setCompte(Compte compte) {
			this.compte = compte;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------4_Méthodes---------------------------------------------------------------------
		/**
		 * 4_Méthodes
		 */
		
		@Override
		public String toString() {
			return "Carte [id_carte=" + id_carte + ", numCarte=" + numCarte + ", typeCarte=" + typeCarte
					+ ", Nomtitulaire=" + Nomtitulaire + ", Plafond=" + plafond + "]";
		}	
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------

}


