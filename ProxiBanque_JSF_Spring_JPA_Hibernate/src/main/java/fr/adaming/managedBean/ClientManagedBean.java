package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.Compte;
import fr.adaming.service.ICompteService;

@ManagedBean(name = "MB")
@ViewScoped
public class ClientManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Compte compte;
	private Compte debit;
	private Compte credit;
	private double montant;
	private List<Compte> listCompte;
	
	@ManagedProperty(value = "#{compteService}")
	ICompteService compteService;
	
	

	/**
	 * 
	 */
	public ClientManagedBean() {
		this.compte=new Compte();
		this.debit=new Compte();
		this.credit=new Compte();
	}


	public Compte getCompte() {
		return compte;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

