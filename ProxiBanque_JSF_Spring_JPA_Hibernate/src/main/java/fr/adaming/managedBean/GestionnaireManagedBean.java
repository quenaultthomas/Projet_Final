package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@ManagedBean(name="GestMB")
public class GestionnaireManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Compte cpt;
	private Compte cpt2;
	private int id;
	private int id2;
	private double montant;
	private Client client;
	private Carte carte;
	

	private List<Client> listClient;
	
	private List<Compte> listCpt;

	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;
	
	@ManagedProperty(value = "#{clientService}")
	IClientService clientService;
	
	@ManagedProperty(value = "#{carteService}")
	ICarteService carteService;
	
	HttpSession session;

	public GestionnaireManagedBean() {
		this.cpt = new Compte();
		this.client= new Client();
	}



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



	@Override
	public String toString() {
		return "GestionnaireManagedBean [cpt=" + cpt + ", cpt2=" + cpt2 + ", id=" + id + ", id2=" + id2 + ", montant="
				+ montant + ", client=" + client + ", carte=" + carte + ", listClient=" + listClient + ", listCpt="
				+ listCpt + "]";
	}

	
}
