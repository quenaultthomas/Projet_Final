package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteService {


	public void AjouterCompte(Compte compte);
	
	public void ModifierCompte(Compte compte);
	
	public void SupprimerCompte(Compte compte);
	
	public Compte getCompteById(int id_compte);
	
	public List<Compte> getAllCompte();
	
}
