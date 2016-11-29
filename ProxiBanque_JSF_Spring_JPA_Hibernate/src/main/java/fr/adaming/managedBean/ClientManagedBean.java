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

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Operation;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IOperationService;

/**
 * 
 * @author inti0292
 *
 *ManagedBean permettant la gestion de la vue (controleur) du côté client
 */
@ManagedBean(name = "ClientMB")
@SessionScoped
public class ClientManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Déclaration des attributs nécessaires au fonctionnement du ManagedBean 
	 */
	private Client client;
	private Compte compte;
	private int id_compte;
	private int id_debit;

	private double montant;
	private List<Compte> listCompte;
	private List<Operation> listOperation;

	/**
	 * Injection dépendance des service, permettant l'iutilisation des dfifférentes méthodes
	 */
	@ManagedProperty(value = "#{clientService}")
	IClientService clientService;

	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;

	@ManagedProperty(value = "#{operationService}")
	IOperationService operationService;

	HttpSession session;

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Le Constructeur 
	 */

	public ClientManagedBean() {
		this.compte = new Compte();
		this.client = new Client();
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------3_Les Getters et
	// Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */

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
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

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
	 * @return the id_debit
	 */
	public int getId_debit() {
		return id_debit;
	}

	/**
	 * @param id_debit the id_debit to set
	 */
	public void setId_debit(int id_debit) {
		this.id_debit = id_debit;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return the listCompte
	 */
	public List<Compte> getListCompte() {
		return listCompte;
	}

	/**
	 * @param listCompte the listCompte to set
	 */
	public void setListCompte(List<Compte> listCompte) {
		this.listCompte = listCompte;
	}

	/**
	 * @return the listOperation
	 */
	public List<Operation> getListOperation() {
		return listOperation;
	}

	/**
	 * @param listOperation the listOperation to set
	 */
	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @return the compteService
	 */
	public ICompteService getCompteService() {
		return compteService;
	}

	/**
	 * @param compteService the compteService to set
	 */
	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}

	/**
	 * @return the operationService
	 */
	public IOperationService getOperationService() {
		return operationService;
	}

	/**
	 * @param operationService the operationService to set
	 */
	public void setOperationService(IOperationService operationService) {
		this.operationService = operationService;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
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
	 * 4_Méthodes
	 */

	
	/**
	 * @postConstruct
	 * 
	 * Methode init, permet l'initialisation de la listeDeCompte en fonction du client en session. 
	 * 
	 * @return listCompte.
	 */
	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
	}

	
//	public String Connexion() {
//		return "connexionClient.xhtml";
//	}

	/**
	 * Methode IsExist, permet l'identification du client. la methode verifie l'existance d'un client 
	 * 
	 * Elle permet également de telécharger toutes les informations concernant le client
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String IsExist() {
		int verif = clientService.isExistClientService(client.getMail(), client.getPassword());

		if (verif == 1) {

			client = clientService.getClientByIdentifiantService(client.getMail(), client.getPassword());

			System.out.println(client);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client", client);
			this.listCompte = compteService.getCompteByIdCLient(client.getId_client());

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

			return "infosClient.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Le login ou le mot de passe est incorrect !!"));

			return "connexionClient.xhtml";
		}
	}

	
	/**
	 * Methode virement, 
	 * 
	 * permet la réalisation d'un virement de compte à compte,
	 * 
	 * le client peut choisir entre deux de ses comptes grace à un menu déroulant.
	 * 
	 * Elle permet le controle de du découvert et d'empecher les virements dans le cas ou l:e solde est insuffisante.
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String virement() {

		Compte compte = compteService.getCompteById(id_debit);
		
		if(compte.getDecouvert()<(compte.getSolde()-montant)){
		
		compteService.virement(montant, id_debit, id_compte);

		Calendar c = Calendar.getInstance();

		Compte depot = compteService.getCompteById(id_compte);

		Compte retrait = compteService.getCompteById(id_debit);

		Operation opeDepot = new Operation("Virement du Compte Numero : " + retrait.getNumero(), (float) montant,
				c.getTime());

		Operation opeRetrait = new Operation("Virement vers Compte Numero : " + depot.getNumero(), (float) -montant,
				c.getTime());

		opeDepot.setCompte(depot);

		opeRetrait.setCompte(retrait);

		operationService.ajouterOperationService(opeDepot);

		operationService.ajouterOperationService(opeRetrait);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Valide", "Le virement a été effectué"));
		
		return "infosClient.xhtml";
		}else{
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur", "Le montant de votre compte est insuffisant"));
			
			return "virement.xhtml";
		}
	}

	/**
	 * Methode Depot, 
	 * 
	 * permet la réalisation d'un depot sur un compte,
	 * 
	 * le client peut choisir son compte grace à un menu déroulant.
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String depot() {

		compteService.depot(montant, id_compte);

		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("depot", (float) montant, c.getTime());

		ope.setCompte(compte);

		operationService.ajouterOperationService(ope);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Valide", "Le dépot a été effectué"));
		
		return "infosClient.xhtml";
		
		}

	
	/**
	 * Methode Retrait, 
	 * 
	 * permet la réalisation d'un retrait sur un ciompte client,
	 * 
	 *  le client peut choisir son compte grace à un menu déroulant.
	 * 
	 * Elle permet le controle de du découvert et d'empecher les retraits dans le cas ou le solde est insuffisante.
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String retrait() {
		
		Compte compte = compteService.getCompteById(id_compte);
		
		if(compte.getDecouvert()<(compte.getSolde()-montant)){
		
		compteService.retrait(montant, id_compte);

		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("retrait", (float) -montant, c.getTime());

		ope.setCompte(compteService.getCompteById(id_compte));

		operationService.ajouterOperationService(ope);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Valide", "Le retrait a été effectué"));
		
		return "infosClient.xhtml";
		
		}else{
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur", "Le montant de votre compte est insuffisant"));
			
			return "retrait.xhtml";
		}
	}


	/**
	 * Methode rechercheCompteByIdClient
	 * 
	 * Cette methode permet la recherche des comptes de chaque client par l'id de celui ci 
	 */
	public void rechercheCompteByIdClient() {
		listCompte = compteService.getCompteByIdCLient(client.getId_client());
	}

	/**
	 * Methode getCompteById
	 * 
	 * Cette Methode permet de rechercher le compte par son id
	 * 
	 * Elle est utile notamment pour la recherche des informations concernant le compte
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String getCompteById() {
		compte = compteService.getCompteById(compte.getId_compte());

		listOperation = operationService.getOperationsByIdCompteService(compte.getId_compte());

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compte", compte);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listOperation", listOperation);

		return "infosCompte.xhtml";
	}

	
	/**
	 * Methode modifier
	 * 
	 * Cette methode permet de modifier les informations personnelles d'un client 
	 * 
	 * @return la page infosClient.xhtml
	 */
	public String modifier() {
		clientService.updateClientService(client);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client", client);
		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		return "infosClient.xhtml";
	}

	
	/**
	 * Methode de redirection
	 * 
	 * @return "infosClient.xhtml"
	 */
	public String GotoInfoClient() {
		return "infosClient.xhtml";
	}

	/**
	 * Methode de redirection
	 * 
	 * @return "retrait.xhtml"
	 */
	public String GotoRetrait() {
		return "retrait.xhtml";
	}

	/**
	 * Methode de redirection
	 * 
	 * @return "depot.xhtml"
	 */
	public String GotoDepot() {
		return "depot.xhtml";
	}

	/**
	 * Methode de redirection
	 * 
	 * @return "virement.xhtml"
	 */
	public String GotoVirement() {
		return "virement.xhtml";
	}

	/**
	 * Methode de redirection
	 * 
	 * @return "modifierClient.xhtml
	 */
	public String GotoModifier() {
		return "modifierClient.xhtml";
	}
	
	/**
	 * Methode de redirection
	 * 
	 * @return "/index.xhtml"
	 */
	public String GotoIndex(){
		return "/index.xhtml";
	}

	/**
	 * Methode de redirection
	 * 
	 * @return "connexionClient.xhtml"
	 */
	public String GotoConnexion() {
		return "connexionClient.xhtml";

	}

}
