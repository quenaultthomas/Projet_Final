package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.model.Compte;

public class CompteDaoImpl implements ICompteDao {

	@Override
	public void AjouterCompte(Compte compte) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	
	em.persist(compte);
	
	}

	@Override
	public void ModifierCompte(Compte compte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Compte mergeCompte = em.find(Compte.class, compte.getId_compte());
		
		//Modification des parametres de la table 
		mergeCompte.setNumero(compte.getNumero());
		mergeCompte.setTypeCompte(compte.getTypeCompte());
		mergeCompte.setSolde(compte.getSolde());
		mergeCompte.setDecouvert(compte.getDecouvert());
		mergeCompte.setTauxRemuneration(compte.getTauxRemuneration());
		
		em.merge(mergeCompte);
		
		tx.commit();
		em.close();
		emf.close();
	}

	@Override
	public void SupprimerCompte(Compte compte) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			// Récupérer un user de l'id 6
			Compte delCompte = em.find(Compte.class, compte.getId_compte());
			
			// supprimer l'objet u
			em.remove(delCompte);

			tx.commit();
			em.close();
			emf.close();
		}
		
	

	@Override
	public Compte getCompteById(int id_compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getAllCompte() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
