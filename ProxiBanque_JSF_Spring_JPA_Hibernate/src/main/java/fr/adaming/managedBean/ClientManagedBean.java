package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Operation;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IOperationService;

@ManagedBean(name = "ClientMB")
@SessionScoped
public class ClientManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Client client;
	private Compte compte;
	private int id_compte;
	private int id_debit;

	private double montant;
	private List<Compte> listCompte;
	private List<Operation> listOperation;

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
	 * 2_Les constructeurs
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

	public Compte getCompte() {
		return compte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public List<Compte> getListCompte() {
		return listCompte;
	}

	public void setListCompte(List<Compte> listCompte) {
		this.listCompte = listCompte;
	}

	public ICompteService getCompteService() {
		return compteService;
	}

	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Operation> getListOperation() {
		return listOperation;
	}

	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}

	public IOperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(IOperationService operationService) {
		this.operationService = operationService;
	}

	public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	public int getId_debit() {
		return id_debit;
	}

	public void setId_debit(int id_debit) {
		this.id_debit = id_debit;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */

	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
	}

	public String Connexion() {
		return "connexionClient.xhtml";
	}

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

	public String virement() {
		
		 	compteService.virement(montant, id_debit, id_compte);

			Calendar c = Calendar.getInstance();
			
			Compte depot = compteService.getCompteById(id_compte);
			
			Compte retrait = compteService.getCompteById(id_debit);

			Operation opeDepot = new Operation("Virement du Compte Numero : " + retrait.getNumero(), (float) montant, c.getTime());
			
			Operation opeRetrait = new Operation("Virement vers Compte Numero : " + depot.getNumero(), (float) -montant, c.getTime());

			opeDepot.setCompte(depot);
			
			opeRetrait.setCompte(retrait);

			operationService.ajouterOperationService(opeDepot);
			
			operationService.ajouterOperationService(opeRetrait);

			this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

			return "infosClient.xhtml";
	}

	public String depot() {

		compteService.depot(montant, id_compte);

		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("depot", (float) montant, c.getTime());

		ope.setCompte(compteService.getCompteById(id_compte));

		operationService.ajouterOperationService(ope);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		return "infosClient.xhtml";
	}

	public String retrait() {
		
		compteService.retrait(montant, id_compte);

		Calendar c = Calendar.getInstance();

		Operation ope = new Operation("retrait", (float) -montant, c.getTime());

		ope.setCompte(compteService.getCompteById(id_compte));

		operationService.ajouterOperationService(ope);

		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);

		return "infosClient.xhtml";

	}

	public void rechercheCompteByIdClient() {
		listCompte = compteService.getCompteByIdCLient(client.getId_client());
	}

	public String getCompteById() {
		compte = compteService.getCompteById(compte.getId_compte());

		listOperation = operationService.getOperationsByIdCompteService(compte.getId_compte());

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compte", compte);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listOperation", listOperation);

		return "infosCompte.xhtml";
	}
	
	public String modifier(){
		clientService.updateClientService(client);
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client", client);
		this.listCompte = compteService.getCompteByIdCLient(client.getId_client());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);
		
		return "infosClient.xhtml";
	}

	public String GotoInfoClient() {
		return "infosClient.xhtml";
	}

	public String GotoRetrait() {
		return "retrait.xhtml";
	}

	public String GotoDepot() {
		return "depot.xhtml";
	}

	public String GotoVirement() {
		return "virement.xhtml";
	}
	
	public String GotoModifier() {
		return "modifierClient.xhtml";
	}

}
