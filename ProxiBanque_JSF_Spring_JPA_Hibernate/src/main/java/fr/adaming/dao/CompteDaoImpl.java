package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Compte;

@Repository
public class CompteDaoImpl implements ICompteDao {

	@PersistenceContext(unitName="ProxyBanque")
	EntityManager em;
	
	@Override
	public void AjouterCompte(Compte compte) {
	
	em.persist(compte);
	
	}

	@Override
	public void ModifierCompte(Compte compte) {
		
		
		Compte mergeCompte = em.find(Compte.class, compte.getId_compte());
		
		//Modification des parametres de la table 
		mergeCompte.setNumero(compte.getNumero());
		mergeCompte.setTypeCompte(compte.getTypeCompte());
		mergeCompte.setSolde(compte.getSolde());
		mergeCompte.setDecouvert(compte.getDecouvert());
		mergeCompte.setTauxRemuneration(compte.getTauxRemuneration());
		
		em.merge(mergeCompte);
		
	}

	@Override
	public void SupprimerCompte(Compte compte) {

			// Récupérer un user de l'id 6
			Compte delCompte = em.find(Compte.class, compte.getId_compte());
			
			// supprimer l'objet u
			em.remove(delCompte);

		}
		
	

	@Override
	public Compte getCompteById(int id_compte) {
				
		Query query = em.createNamedQuery("getCompteById");
		
		return (Compte) query.getSingleResult();
	}

	@Override
	public List<Compte> getAllCompte() {
		
		Query query = em.createNamedQuery("getAllCompte");
		
		return query.getResultList();
	}	
	
	
}
