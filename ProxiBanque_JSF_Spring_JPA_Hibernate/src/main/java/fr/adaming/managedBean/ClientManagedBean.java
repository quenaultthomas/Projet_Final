package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@ManagedBean(name = "ClientMB")
@ViewScoped
public class ClientManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Client client;
	private Compte compte;
	private Compte debit;
	private Compte credit;
	private double montant;
	private List<Compte> listCompte;

	@ManagedProperty(value = "#{clientService}")
	IClientService clientService;
	
	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;
	
	
	
	HttpSession session;
	
	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */

	public ClientManagedBean() {
		this.compte = new Compte();
		this.debit = new Compte();
		this.credit = new Compte();
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

	public Compte getDebit() {
		return debit;
	}

	public void setDebit(Compte debit) {
		this.debit = debit;
	}

	public Compte getCredit() {
		return credit;
	}

	public void setCredit(Compte credit) {
		this.credit = credit;
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

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	
	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		client = (Client) session.getAttribute("client");
	}
	
	public String Connexion(){
		return "connexionClient.xhtml";
	}
	
	public String IsExist(){
		int verif  = clientService.isExistClientService(client.getMail(), client.getPassword());
		
		if (verif==1){
					
			//GetClient By Mail et Password
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client", client);
			listCompte = compteService.getCompteByIdCLient(client.getId_client());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCompte", listCompte);
			
			return "infosClient.xhtml";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect !!"));
			
			return "connexionClient.xhtml";
		}
	}
	
	public void rechercherDebiteur(){
		debit = compteService.getCompteById(debit.getId_compte());
	}
	public void rechercherCrediteur(){
		credit = compteService.getCompteById(credit.getId_compte());
	}
	
	public String virement(){
		compteService.virement(montant, debit.getId_compte(), credit.getId_compte());
		return "accueil.xhtml";
	}
	
	public String depot(){
		compteService.depot(montant, credit.getId_compte());
		return "accueil.xhtml";
	}
	
	public void retrait(){
		compteService.retrait(montant, debit.getId_compte());
	}
	
	public void rechercheCompteByIdClient(){
		listCompte = compteService.getCompteByIdCLient(client.getId_client());
	}
}
