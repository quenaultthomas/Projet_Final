package fr.adaming.managedBean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

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

@ManagedBean(name="GestMB")
@SessionScoped
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
	private Client client2;
	
	private UploadedFile file;
	
	private List<Client> listClient;
	private List<Gestionnaire> listeGestionnaires;
	private List<Compte> listCpt;
	private List<Operation> listOperation;
	private List<Compte> listCptClient2;

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

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------2_Les constructeurs------------------------------------------------------------	
		/**
		 * 2_Les constructeurs
		 */
	
	public GestionnaireManagedBean() {
		this.cpt = new Compte();
		this.client= new Client();
		this.carte= new Carte();
		this.gestionnaire = new Gestionnaire();
		this.client2 = new Client();
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

	public List<Operation> getListOperation() {
		return listOperation;
	}

	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}

	/**
	 * @return the listeGestionnaires
	 */
	public List<Gestionnaire> getListeGestionnaires() {
		return listeGestionnaires;
	}

	/**
	 * @param listeGestionnaires the listeGestionnaires to set
	 */
	public void setListeGestionnaires(List<Gestionnaire> listeGestionnaires) {
		this.listeGestionnaires = listeGestionnaires;
	}


	public Client getClient2() {
		return client2;
	}

	public void setClient2(Client client2) {
		this.client2 = client2;
	}

	public List<Compte> getListCptClient2() {
		return listCptClient2;
	}

	public void setListCptClient2(List<Compte> listCptClient2) {
		this.listCptClient2 = listCptClient2;
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

	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------4_Méthodes---------------------------------------------------------------------
		/**
		 * 4_Méthodes
		 */


	/**
	 * Methode TOString retourne un string
	 */
	@Override
	public String toString() {
		return "GestionnaireManagedBean [cpt=" + cpt + ", cpt2=" + cpt2 + ", id=" + id + ", id2=" + id2 + ", montant="
				+ montant + ", client=" + client + ", carte=" + carte + ", listClient=" + listClient + ", listCpt="
				+ listCpt + "]";
	}
	
	/**
	 * Methode init pour initilaiser la liste  
	 * Retourne un void
	 */
	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
	}
	
	/**
	 * Methode getCompteById pour recuperer un compte par son ID 
	 * Retourne une page de redirection
	 */
	
	public String getCompteById() {
		cpt = compteService.getCompteById(cpt.getId_compte());

		listOperation = operationService.getOperationsByIdCompteService(cpt.getId_compte());

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compte", cpt);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listOperation", listOperation);

		return "infosCompte.xhtml";
		
	}
	
	/**
	 * Methode  pour rechercher un debiteur par son ID
	 * Retourne un void
	 */
	
	public void rechercherDebiteur(){
		cpt = compteService.getCompteById(cpt.getId_compte());
	}
	
	/**
	 * Methode pour recherhcer un crediteur par son ID
	 * Retourne un void
	 */
	
	public void rechercherCrediteur(){
		cpt2 = compteService.getCompteById(cpt2.getId_compte());
	}
	
	/**
	 * Methode virement 
	 * Retourne une page de redirection
	 */
	
	public String virement(){
		System.out.println(id);
		System.out.println(id2);
		
		
		Compte compte = compteService.getCompteById(id);
		
		if(compte.getDecouvert()<(compte.getSolde()-montant)){
			
		compteService.virement(montant, id, id2);
		listCpt = compteService.getCompteByIdCLient(client.getId_client());
		Calendar c = Calendar.getInstance();

		Compte depot = compteService.getCompteById(id2);

		Compte retrait = compteService.getCompteById(id);

		Operation opeDepot = new Operation("Virement du Compte Numero : " + retrait.getNumero(), (float) montant,
				c.getTime());

		Operation opeRetrait = new Operation("Virement vers Compte Numero : " + depot.getNumero(), (float) -montant,
				c.getTime());

		opeDepot.setCompte(depot);

		opeRetrait.setCompte(retrait);

		operationService.ajouterOperationService(opeDepot);

		operationService.ajouterOperationService(opeRetrait);

		this.listCpt = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCpt);

		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Valide", "Le virement a été effectué"));
		return "listeCompte.xhtml";
		
		}else{
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur", "Le montant de votre compte est insuffisant"));
			
			return "virement.xhtml";
		}
	}
	
	/**
	 * Methode depot pour depot de l'argent sur un compte  
	 * Retourne une page de redirection
	 */
	
	public String depot(){
		compteService.depot(montant, id);

		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("depot", (float) montant, c.getTime());

		ope.setCompte(compteService.getCompteById(id));

		operationService.ajouterOperationService(ope);

		this.listCpt = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCpt);

		
		return "listeCompte.xhtml";
	}
	
	/**
	 * Methode retrait pour retirer de l'argent sur un compte  
	 * Retourne une page de redirection
	 */
	
	public String retrait(){
		
	
		Compte compte = compteService.getCompteById(id);
		
		if(compte.getDecouvert()<(compte.getSolde()-montant)){
			
		
		compteService.retrait(montant, id);
		
		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("retrait", (float) -montant, c.getTime());

		ope.setCompte(compteService.getCompteById(id));

		operationService.ajouterOperationService(ope);

		this.listCpt = compteService.getCompteByIdCLient(client.getId_client());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCpt);
		
		return "listeCompte.xhtml";
		
			}else{
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur", "Le montant de votre compte est insuffisant"));
			
			return "retrait.xhtml";
		}
	}
	
	/**
	 * Methode rechercheCompteByIdClient pour recuperer un compte par l'ID du client
	 * Retourne une page de redirection
	 */
	
	public String rechercheCompteByIdClient(){
		listCpt = compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";
	}
	
	/**
	 * Methode ajouter un compte 
	 * Retourne une page de redirection
	 */
	
	public String addCpt() {
		cpt.setClient(client);
		compteService.AjouterCompte(cpt);
		this.cpt = new Compte();
		listCpt=compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";

	}

	/**
	 * Methode pour modifier un compte
	 * Retourne une page de redirection
	 */
	
	public String upCpt() {
		compteService.ModifierCompte(cpt);
		listCpt=compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";

	}

	/**
	 * Methode supprimer un compte 
	 * Retourne une page de redirection
	 */
	
	public String deleteCpt() {
		
		compteService.SupprimerCompte(cpt);
		listCpt=compteService.getCompteByIdCLient(client.getId_client());
		return "listeCompte.xhtml";

	}
	
	/**
	 * Methode pour ajouter 
	 * Retourne une page de redirection
	 */
	
	public String addCarte() {
		carteService.AjouterCarteService(carte);
		return null;
	}

	/**
	 * Methode pour modifier la carte 
	 * Retourne une page de redirection
	 */
	
	public String upCarte() {
		carteService.ModifierCarteService(carte);
		return null;
	}

	/**
	 * Methode pour supprimer une carte 
	 * Retourne une page de redirection
	 */
	
	public String deleteCarte() {
		
		carteService.SupprimerCarteService(carte);
		return null;
	}
	
	/**
	 * Methode pour ajouter
	 * Retourne une page de redirection
	 */
	
	public String addClient() {
		
		client.setRole("client");
		client.setGestionnaire(gestionnaire);
		clientService.addClientService(client);
		this.client = new Client();
		return "ajoutClient.xhtml";
	}

	/**
	 * Methode pour modifier un client 
	 * Retourne une page de redirection
	 */
	
	public String upClient() {
		clientService.updateClientService(client);
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}

	/**
	 * Methode pour supprimer un client
	 * Retourne une page de redirection
	 */
	
	public String deleteClient() {		
		clientService.deleteClientService(client.getId_client());
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}
	
	/**
	 * Methode pour la securite 
	 * Retourne une page de redirection
	 */
	
	public String IsExist(){
		int verif  = gestionnaireService.isExistGestionnaireService(gestionnaire.getLogin(), gestionnaire.getPassword());
		
		if (verif==1){
					
			gestionnaire = gestionnaireService.getGestByIdentificationService(gestionnaire.getLogin(), gestionnaire.getPassword());
			
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gestionnaire", gestionnaire);
			
			System.out.println(gestionnaire.getId_gestionnaire());
			
			listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listClient", listClient);
			
			return "accueilGestionnaire.xhtml";
			
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect !!"));
			
			return "connexionGestionnaire.xhtml";
		}
	}
	
	/**
	 * Methode  pour rediriger vers le formulaire d'accueil du gestionnaire 
	 * Retourne une page de redirection
	 */
	
	public String aiguillageAccueil(){
		listClient = clientService.getClientsByIdGestionnaireService(gestionnaire.getId_gestionnaire());
		return "accueilGestionnaire.xhtml";
	}
	
	/**
	 * Methode  pour rediriger vers le formulaire de modif d'un client 
	 * Retourne une page de redirection
	 */
	
	public String aiguillageFormModifClient(){
		listeGestionnaires = gestionnaireService.getAllGestionnairesService();
		return "formModifClient.xhtml";
	}
	/**
	 * Methode  pour rediriger vers le formulaire de modification d'un compte
	 * Retourne une page de redirection
	 */
	
	public String aiguillageFormModifCmtp(){
		listClient = clientService.getAllClientService();
		return "modificationCompte.xhtml";
		
		
	}
	/**
	 * Methode pour rediriger vers le formulaire d'ajout d'un compte
	 * Retourne une page de redirection
	 */
	
	public String aiguillageAjoutCompte(){
		this.cpt=new Compte();
		return "ajoutCompte.xhtml";
		
	}
	
	/**
	 * Methode pour rediriger vers le formulaire d'ajout d'un client
	 * Retourne une page de redirection
	 */
	
	public String aiguillageAjoutClient() {
		this.client = new Client();
		return "ajoutClient.xhtml";
	}
	
	/**
	 * Methode pour rediriger vers l'accueil des comptes
	 * Retourne une page de redirection
	 */
	
	public String gotoHome(){
		return "listeCompte.xhtml";
	}
	
	/**
	 * Methode upload pour recuperer une image
	 * Retourne une page de redirection
	 */
	
	 public void upload() {
	        if(file != null) {
	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            client.setPhoto(file.getContents());
	            System.out.println(client.getPhoto());
	        }
	 }
	 public void rechercheClient2(){
		 
		 client2 = clientService.getClientByNomPrenomService(client2.getNom(), client2.getPrenom());
		 listCptClient2 = compteService.getCompteByIdCLient(client2.getId_client());
	 }
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
}
