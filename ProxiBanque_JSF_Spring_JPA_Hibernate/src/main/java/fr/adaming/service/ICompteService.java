package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteService {


	public void AjouterCompte(Compte compte);
	
	public void ModifierCompte(Compte compte);
	
	public void SupprimerCompte(Compte compte);
	
	public Compte getCompteById(int id_compte);
	
	public List<Compte> getAllCompte();
	
	void virement(double montant, int id_compteD, int id_compteC);

	void retrait(double montant, int id_compteD);

	void depot(double montant, int id_compteC);
	
	public List<Compte> getCompteByIdCLient(int id_client);
	
}
