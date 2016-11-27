package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Operation;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IGestionnaireService;
import fr.adaming.service.IOperationService;

@ManagedBean(name = "GestMB")
@SessionScoped
public class GestionnaireManagedBean implements Serializable {

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------1_Les propriétés (champs,
	// attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */

	private static final long serialVersionUID = 1L;

	private int id_gestionnaire;
	private Compte cpt;
	private Compte cpt2;
	private int id;
	private int id2;
	private double montant;
	private Client client;
	private Carte carte;
	private Gestionnaire gestionnaire;

	private List<Client> listClient;
	private List<Gestionnaire> listeGestionnaires;
	private List<Compte> listCpt;

	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;

	@ManagedProperty(value = "#{clientService}")
	IClientService clientService;

	@ManagedProperty(value = "#{carteService}")
	ICarteService carteService;

	@ManagedProperty(value = "#{operationService}")
	IOperationService operationService;

	@ManagedProperty(value = "#{gestionService}")
	IGestionnaireService gestionnaireService;

	HttpSession session;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */

	public GestionnaireManagedBean() {
		this.cpt = new Compte();
		this.client = new Client();
		this.carte = new Carte();
		this.gestionnaire = new Gestionnaire();
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------3_Les Getters et
	// Setters-------------------------------------------------------
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

	/**
	 * @return the listeGestionnaires
	 */
	public List<Gestionnaire> getListeGestionnaires() {
		return listeGestionnaires;
	}

	/**
	 * @param listeGestionnaires
	 *            the listeGestionnaires to set
	 */
	public void setListeGestionnaires(List<Gestionnaire> listeGestionnaires) {
		this.listeGestionnaires = listeGestionnaires;
	}

	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setCarteService(ICarteService carteService) {
		this.carteService = carteService;
	}

	public void setOperationService(IOperationService operationService) {
		this.operationService = operationService;
	}

	public void setGestionnaireService(IGestionnaireService gestionnaireService) {
		this.gestionnaireService = gestionnaireService;
	}

	public void setListCpt(List<Compte> listCpt) {
		this.listCpt = listCpt;
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
		return "GestionnaireManagedBean [cpt=" + cpt + ", cpt2=" + cpt2 + ", id=" + id + ", id2=" + id2 + ", montant="
				+ montant + ", client=" + client + ", carte=" + carte + ", listClient=" + listClient + ", listCpt="
				+ listCpt + "]";
	}

	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		// listClient =
		// clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
	}

	public void rechercherDebiteur() {
		cpt = compteService.getCompteById(cpt.getId_compte());
	}

	public void rechercherCrediteur() {
		cpt2 = compteService.getCompteById(cpt2.getId_compte());
	}

	public String virement() {
		compteService.virement(montant, id, id2);
		
		Calendar c = Calendar.getInstance();
		Compte depot = compteService.getCompteById(id2);		
		Compte retrait = compteService.getCompteById(id);
		Operation opeDepot = new Operation("Virement du Compte Numero : " + retrait.getNumero(), (float) montant, c.getTime());		
		Operation opeRetrait = new Operation("Virement vers Compte Numero : " + depot.getNumero(), (float) -montant, c.getTime());
		opeDepot.setCompte(depot);		
		opeRetrait.setCompte(retrait);
		operationService.ajouterOperationService(opeDepot);		
		operationService.ajouterOperationService(opeRetrait);
		
		listCpt = compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";
	}

	public String depot() {
		compteService.depot(montant, cpt.getId_compte());
		return "accueil.xhtml";
	}

	public String retrait() {
		compteService.retrait(montant, cpt.getId_compte());
		return null;
	}

	public String rechercheCompteByIdClient() {
		listCpt = compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";
	}

	public String addCpt() {
		compteService.AjouterCompte(cpt);
		;
		return null;
	}

	public String upCpt() {
		compteService.ModifierCompte(cpt);
		return null;
	}

	public String deleteCpt() {

		compteService.SupprimerCompte(cpt);
		return null;
	}

	public String addCarte() {
		carteService.AjouterCarteService(carte);
		return null;
	}

	public String upCarte() {
		carteService.ModifierCarteService(carte);
		return null;
	}

	public String deleteCarte() {

		carteService.SupprimerCarteService(carte);
		return null;
	}

	public String addClient() {

		client.setRole("client");
		client.setGestionnaire(gestionnaire);
		clientService.addClientService(client);
		this.client = new Client();
		return "ajoutClient.xhtml";
	}

	public String upClient() {
		clientService.updateClientService(client);
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}

	public String deleteClient() {
		clientService.deleteClientService(client.getId_client());
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}

	public String IsExist() {
		int verif = gestionnaireService.isExistGestionnaireService(gestionnaire.getLogin(), gestionnaire.getPassword());

		if (verif == 1) {

			gestionnaire = gestionnaireService.getGestByIdentificationService(gestionnaire.getLogin(),
					gestionnaire.getPassword());

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gestionnaire", gestionnaire);

			System.out.println(gestionnaire.getId_gestionnaire());

			listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listClient", listClient);

			return "accueilGestionnaire.xhtml";

		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Le login ou le mot de passe est incorrect !!"));

			return "connexionGestionnaire.xhtml";
		}
	}

	public String aiguillageAccueil() {
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}

	public String aiguillageFormModifClient() {
		listeGestionnaires = gestionnaireService.getAllGestionnairesService();
		return "formModifClient.xhtml";
	}

	public String aiguillageAjoutClient() {
		this.client = new Client();
		return "ajoutClient.xhtml";
	}
	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

}
