/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Guerin Victor
 *
 */
@Entity
@Table
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
	private int Number;
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------2_Les constructeurs------------------------------------------------------------	
		/**
		 * 2_Les constructeurs
		 */
		public Carte() {
			super();
		}
		
		public Carte(int id_carte, long numCarte, String typeCarte, String nomtitulaire, int number) {
			super();
			this.id_carte = id_carte;
			this.numCarte = numCarte;
			this.typeCarte = typeCarte;
			Nomtitulaire = nomtitulaire;
			Number = number;
		}

		public Carte(long numCarte, String typeCarte, String nomtitulaire, int number) {
			super();
			this.numCarte = numCarte;
			this.typeCarte = typeCarte;
			Nomtitulaire = nomtitulaire;
			Number = number;
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

		public int getNumber() {
			return Number;
		}

		public void setNumber(int number) {
			Number = number;
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
					+ ", Nomtitulaire=" + Nomtitulaire + ", Number=" + Number + "]";
		}	
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------

}


