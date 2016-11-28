package fr.adaming.model;

import java.util.List;

public class Audit {
	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
		/**
		 * 1_Les propriétés (champs, attributs)
		 */
	
	private int nbClient;
	
	private int nbGestion;
	
	private double tauxDecouvert;
	
	private double sousDecouvert;
	
	private List<Compte> listCompteDecouvert;

	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------2_Les constructeurs------------------------------------------------------------	
		/**
		 * 2_Les constructeurs
		 */
	public Audit() {
		super();
	}

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------3_Les Getters et Setters-------------------------------------------------------
		/**
		 * 3_Les Getters et Setters
		 */

		public int getNbClient() {
			return nbClient;
		}

		public void setNbClient(int nbClient) {
			this.nbClient = nbClient;
		}

		public int getNbGestion() {
			return nbGestion;
		}

		public void setNbGestion(int nbGestion) {
			this.nbGestion = nbGestion;
		}

		public double getTauxDecouvert() {
			return tauxDecouvert;
		}

		public void setTauxDecouvert(double tauxDecouvert) {
			this.tauxDecouvert = tauxDecouvert;
		}

		public double getSousDecouvert() {
			return sousDecouvert;
		}

		public void setSousDecouvert(double sousDecouvert) {
			this.sousDecouvert = sousDecouvert;
		}

		public List<Compte> getListCompteDecouvert() {
			return listCompteDecouvert;
		}

		public void setListCompteDecouvert(List<Compte> listCompteDecouvert) {
			this.listCompteDecouvert = listCompteDecouvert;
		}

	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------4_Méthodes---------------------------------------------------------------------
		/**
		 * 4_Méthodes
		 */
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------

}
