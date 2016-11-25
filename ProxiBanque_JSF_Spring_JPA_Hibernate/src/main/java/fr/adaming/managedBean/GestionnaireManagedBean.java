package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Gestionnaire;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@ManagedBean(name="GestMB")
public class GestionnaireManagedBean implements Serializable{

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
		/**
		 * 1_Les propriétés (champs, attributs)
		 */
	
	private static final long serialVersionUID = 1L;
	
	private Compte cpt;
	private Compte cpt2;
	private int id;
	private int id2;
	private double montant;
	private Client client;
	private Carte carte;
	private Gestionnaire gestionnaire;

	
	private List<Client> listClient;
	
	private List<Compte> listCpt;

	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;
	
	@ManagedProperty(value = "#{clientService}")
	IClientService clientService;
	
	@ManagedProperty(value = "#{carteService}")
	ICarteService carteService;
	
	HttpSession session;

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------2_Les constructeurs------------------------------------------------------------	
		/**
		 * 2_Les constructeurs
		 */
	
	public GestionnaireManagedBean() {
		this.cpt = new Compte();
		this.client= new Client();
		this.carte= new Carte();
	}

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------3_Les Getters et Setters-------------------------------------------------------
		/**
		 * 3_Les Getters et Setters
		 */

	public Compte getCpt() {
		return cpt;
	}



	public void setCpt(Compte cpt) {
		this.cpt = cpt;
	}



	public Compte getCpt2() {
		return cpt2;
	}



	public void setCpt2(Compte cpt2) {
		this.cpt2 = cpt2;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getId2() {
		return id2;
	}



	public void setId2(int id2) {
		this.id2 = id2;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Carte getCarte() {
		return carte;
	}



	public void setCarte(Carte carte) {
		this.carte = carte;
	}



	public List<Client> getListClient() {
		return listClient;
	}



	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}



	public List<Compte> getListCpt() {
		return listCpt;
	}



	public void setListCpt(List<Compte> listCpt) {
		this.listCpt = listCpt;
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
		return "GestionnaireManagedBean [cpt=" + cpt + ", cpt2=" + cpt2 + ", id=" + id + ", id2=" + id2 + ", montant="
				+ montant + ", client=" + client + ", carte=" + carte + ", listClient=" + listClient + ", listCpt="
				+ listCpt + "]";
	}
	
	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		gestionnaire = (Gestionnaire) session.getAttribute("gestionnaire");
	}
	
	
	public void rechercherDebiteur(){
		cpt = compteService.getCompteById(cpt.getId_compte());
	}
	public void rechercherCrediteur(){
		cpt2 = compteService.getCompteById(cpt2.getId_compte());
	}
	
	public String virement(){
		compteService.virement(montant, cpt.getId_compte(), cpt2.getId_compte());
		return "accueil.xhtml";
	}
	
	public String depot(){
		compteService.depot(montant, cpt.getId_compte());
		return "accueil.xhtml";
	}
	
	public void retrait(){
		compteService.retrait(montant, cpt.getId_compte());
	}
	
	public void rechercheCompteByIdClient(){
		listCpt = compteService.getCompteByIdCLient(client.getId_client());
	}
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
}
