/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thibault
 *
 */
@Entity
@Table
@NamedQueries({
	@NamedQuery(name="getOperationsByIdCompte", query="SELECT o FROM Operation as o WHERE o.compte.id_compte =:id_compte"),
	})
public class Operation implements Serializable {

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
	private int id_operation;
	private String typeOperation;
	private float montant;
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_compte")
	private Compte compte;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */

	/**
	 * 2.1_ Le constructeur Vide
	 */
	public Operation() {
		super();
	}

	/**
	 * 2.2_Constructeur sans Id
	 * 
	 * @param typeOperation
	 * @param montant
	 * @param date
	 */
	public Operation(String typeOperation, float montant, Date date) {
		super();
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.date = date;
	}

	/**
	 * 2.3_Constructeur avec Id
	 * 
	 * @param id_operation
	 * @param typeOperation
	 * @param montant
	 * @param date
	 */
	public Operation(int id_operation, String typeOperation, float montant, Date date) {
		super();
		this.id_operation = id_operation;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.date = date;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------3_Les Getters et
	// Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
	/**
	 * @return the id_operation
	 */
	public int getId_operation() {
		return id_operation;
	}

	/**
	 * @param id_operation
	 *            the id_operation to set
	 */
	public void setId_operation(int id_operation) {
		this.id_operation = id_operation;
	}

	/**
	 * @return the typeOperation
	 */
	public String getTypeOperation() {
		return typeOperation;
	}

	/**
	 * @param typeOperation
	 *            the typeOperation to set
	 */
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte
	 *            the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Redéfinition de toString
	 */

	@Override
	public String toString() {
		return "Operation [id_operation=" + id_operation + ", typeOperation=" + typeOperation + ", montant=" + montant
				+ ", date=" + date + "]";
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

}
