package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Gestionnaire implements Serializable{
	
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
	private int id_gestionnaire;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	@Lob
	private byte[] photo;
	
	@OneToMany(mappedBy="gestionnaire", fetch=FetchType.EAGER)
	private List<Client> client;
	
	
		//----------------------------------------------------------------------------------------------------------------
		//---------------------------------2_Les constructeurs------------------------------------------------------------	
			/**
			 * 2_Les constructeurs
			 */
	
	/**
	 * 
	 */
	public Gestionnaire() {
		super();
	}


		/**
		 * @param nom
		 * @param prenom
		 * @param login
		 * @param password
		 * @param photo
		 */
		public Gestionnaire(String nom, String prenom, String login, String password, byte[] photo) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.photo = photo;
		}


		/**
		 * @param id_gestionnaire
		 * @param nom
		 * @param prenom
		 * @param login
		 * @param password
		 * @param photo
		 */
		public Gestionnaire(int id_gestionnaire, String nom, String prenom, String login, String password,
				byte[] photo) {
			super();
			this.id_gestionnaire = id_gestionnaire;
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.photo = photo;
		}
	
		//----------------------------------------------------------------------------------------------------------------
		//---------------------------------3_Les Getters et Setters-------------------------------------------------------
			/**
			 * 3_Les Getters et Setters
			 */
		
		public int getId_gestionnaire() {
			return id_gestionnaire;
		}


		public void setId_gestionnaire(int id_gestionnaire) {
			this.id_gestionnaire = id_gestionnaire;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public byte[] getPhoto() {
			return photo;
		}


		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}

		
		
		//----------------------------------------------------------------------------------------------------------------
		//---------------------------------4_Méthodes---------------------------------------------------------------------
			/**
			 * 4_Méthodes
			 */
		//----------------------------------------------------------------------------------------------------------------
		//----------------------------------------------------------------------------------------------------------------
		
		@Override
		public String toString() {
			return "Gestionnaire [id_gestionnaire=" + id_gestionnaire + ", nom=" + nom + ", prenom=" + prenom
					+ ", login=" + login + ", password=" + password + ", photo=" + Arrays.toString(photo) + "]";
		}
		
}
