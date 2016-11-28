package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Client implements Serializable{
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
	private int id_client;
	private String nom;
	private String prenom;
	private String password;
	private String adresse;
	private int codePostal;
	private String ville;
	private String mail;
	private String tel;
	private byte[] photo;
	private String role;
	
	@ManyToOne
	@JoinColumn(name="id_gestionnaire")
	private Gestionnaire gestionnaire;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Compte> listeCompte;
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}
	/**
	 * Constructeur avec paramètre sans ID
	 * @param nom
	 * @param prenom
	 * @param password
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param mail
	 * @param tel
	 * @param photo
	 * @param role
	 */
	public Client(String nom, String prenom, String password, String adresse, int codePostal, String ville, String mail,
			String tel, byte[] photo, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.photo = photo;
		this.role = role;
	}
	/**
	 * Constructeur avec paramètres et avec ID 
	 * @param id_client
	 * @param nom
	 * @param prenom
	 * @param password
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param mail
	 * @param tel
	 * @param photo
	 * @param role
	 */
	public Client(int id_client, String nom, String prenom, String password, String adresse, int codePostal, String ville,
			String mail, String tel, byte[] photo, String role) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.photo = photo;
		this.role = role;
	}	
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
	/**
	 * @return the id_client
	 */
	public int getId_client() {
		return id_client;
	}
	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
/**
	 * @return the gestionnaire
	 */
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}
	/**
	 * @param gestionnaire the gestionnaire to set
	 */
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	/**
	 * @return the listeCompte
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}
	/**
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}
	//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", mail=" + mail
				+ ", tel=" + tel + ", photo=" + Arrays.toString(photo) + ", role=" + role + "]";
	}
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
