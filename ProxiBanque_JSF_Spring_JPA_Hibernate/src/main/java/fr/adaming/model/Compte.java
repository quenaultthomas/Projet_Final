package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------1_Les propriétés (champs,
	// attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_compte;
	@Column
	private String numero;
	@Column
	private String typeCompte;
	@Column
	private double decouvert;
	@Column
	private float tauxRemuneration;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */

	/**
	 * 2.1_ Le constructeur Vide
	 */
	public Compte() {
		super();
	}

	/**
	 * 2.2_Constructeur sans Id
	 * 
	 * @param numero
	 * @param typeCompte
	 * @param decouvert
	 * @param tauxRemuneration
	 */
	public Compte(String numero, String typeCompte, double decouvert, float tauxRemuneration) {
		super();
		this.numero = numero;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * 2.3_Constructeur avec Id
	 * 
	 * @param id_compte
	 * @param numero
	 * @param typeCompte
	 * @param decouvert
	 * @param tauxRemuneration
	 */
	public Compte(int id_compte, String numero, String typeCompte, double decouvert, float tauxRemuneration) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.tauxRemuneration = tauxRemuneration;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------3_Les Getters et
	// Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */

	public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public float getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	
	@Override
	public String toString() {
		return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", typeCompte=" + typeCompte + ", decouvert="
				+ decouvert + ", tauxRemuneration=" + tauxRemuneration + "]";
	}
	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

}
