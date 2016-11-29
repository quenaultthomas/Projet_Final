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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comptes")
/**
 * 
 * @author inti0292
 *
 *Initialisation des NamedQueries nécessaire à la dao compte
 *
 */
@NamedQueries({ @NamedQuery(name = "getAllCompte", query = "SELECT c FROM Compte c"),
		@NamedQuery(name = "getCompteById", query = "SELECT c FROM Compte as c WHERE c.id_compte =:id"),
		@NamedQuery(name = "getCompteByIdClient", query = "SELECT c FROM Compte as c WHERE c.client.id_client =:id"), })
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------1_Les propriétés (champs,
	// attributs)-------------------------------------------
	/**
	 * Initialisation des attributs et des associations de la classe compte 
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

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToMany(mappedBy = "compte", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Carte> carte;

	@OneToMany(mappedBy = "compte", cascade = CascadeType.REMOVE)
	@JsonIgnore
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
	 * 3_Les Getters et Setters des attributs de la classe compte.
	 */

	/**
	 * @return the id_compte
	 */
	public int getId_compte() {
		return id_compte;
	}

	/**
	 * @param id_compte the id_compte to set
	 */
	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the typeCompte
	 */
	public String getTypeCompte() {
		return typeCompte;
	}

	/**
	 * @param typeCompte the typeCompte to set
	 */
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * @return the tauxRemuneration
	 */
	public float getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * @param tauxRemuneration the tauxRemuneration to set
	 */
	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the carte
	 */
	public List<Carte> getCarte() {
		return carte;
	}

	/**
	 * @param carte the carte to set
	 */
	public void setCarte(List<Carte> carte) {
		this.carte = carte;
	}

	/**
	 * @return the operation
	 */
	public List<Operation> getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthode ToString, nécessaire à l'affichage de l'entité compte dans le projet.
	 * 
	 * @return id_compte, numero, typeCompte, solde, decouvert, tauxRemuneration
	 */
	@Override
	public String toString() {
		return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", typeCompte=" + typeCompte + ", solde="
				+ solde + ", decouvert=" + decouvert + ", tauxRemuneration=" + tauxRemuneration + "]";
	}
	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	
}
