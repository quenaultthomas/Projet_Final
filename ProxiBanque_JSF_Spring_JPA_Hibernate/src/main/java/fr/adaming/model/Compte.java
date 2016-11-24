package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
@NamedQueries({ @NamedQuery(name = "getAllCompte", query = "SELECT c FROM Compte as c"),
		@NamedQuery(name = "getCompteById", query = "SELECT c FROM Compte as c WHERE c.id_compte =:id"),
		@NamedQuery(name = "getCompteByIdClient", query = "SELECT c FROM Compte as c WHERE c.client.id_client =:id"),})
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------1_Les propri�t�s (champs,
	// attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_compte;
	@Column
	private String numero;
	@Column
	private String typeCompte;
	@Column
	private double solde;
	@Column
	private double decouvert;
	@Column
	private float tauxRemuneration;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToMany(mappedBy = "compte", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Carte> carte;

	@OneToMany(mappedBy = "compte", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Operation> operation;

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
	 * @param solde
	 * @param decouvert
	 * @param tauxRemuneration
	 */
	public Compte(String numero, String typeCompte, double solde, double decouvert, float tauxRemuneration) {
		super();
		this.numero = numero;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.decouvert = decouvert;
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * 2.3_Constructeur avec Id
	 *
	 * @param id_compte
	 * @param numero
	 * @param typeCompte
	 * @param solde
	 * @param decouvert
	 * @param tauxRemuneration
	 */
	public Compte(int id_compte, String numero, String typeCompte, double solde, double decouvert,
			float tauxRemuneration) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.typeCompte = typeCompte;
		this.solde = solde;
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

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Carte> getCarte() {
		return carte;
	}

	public void setCarte(List<Carte> carte) {
		this.carte = carte;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	@Override
	public String toString() {
		return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", typeCompte=" + typeCompte + ", solde="
				+ solde + ", decouvert=" + decouvert + ", tauxRemuneration=" + tauxRemuneration + "]";
	}
	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

}
