package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;

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

	

	public GestionnaireManagedBean() {
		this.cpt = new Compte();
		this.client= new Client();
	}

}
