package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Compte;

@Repository
public class CompteDaoImpl implements ICompteDao {


	@PersistenceContext(name="ProxyBanque")
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
		query.setParameter("id",id_compte);
		
		return (Compte) query.getSingleResult();
	}

	@Override
	public List<Compte> getAllCompte() {
		
		Query query = em.createNamedQuery("getAllCompte");
		
		return query.getResultList();
	}	
	
	@Override
	public void depot(double montant, int id_compteC) {
		Compte c = this.getCompteById(id_compteC);
		double compteSolde=c.getSolde() ;
		compteSolde= compteSolde+montant;

		c.setSolde(compteSolde);
		this.ModifierCompte(c);
		
	}

	@Override
	public void retrait(double montant, int id_compteD) {
		
		Compte debit = this.getCompteById(id_compteD);
		double compteSolde=debit.getSolde() ;
		
		compteSolde= compteSolde-montant;
		
		if(compteSolde<debit.getDecouvert()){
			//throw new ExceptionMontant("Impossible, le montant demandé est supérieur au solde disponible sur ce compte");
		}else{
		debit.setSolde(compteSolde);
		this.ModifierCompte(debit);
		
		}
		
	}

	@Override
	public void virement(double montant, int id_compteD, int id_compteC)  {
		
		Compte debit = this.getCompteById(id_compteD);
		double compteSolde=debit.getSolde() ;
		
		compteSolde= compteSolde-montant;
		
		if(compteSolde<debit.getDecouvert()){
			//throw new ExceptionMontant("Impossible, le montant demandé est supérieur au solde disponible sur ce compte");
		}else{
		debit.setSolde(compteSolde);
		this.ModifierCompte(debit);
		
		
		Compte credit = this.getCompteById(id_compteC);
		double compteSoldeCredit=credit.getSolde() ;
		compteSoldeCredit= compteSoldeCredit+montant;

		credit.setSolde(compteSoldeCredit);
		this.ModifierCompte(credit);
		}
	}

	@Override
	public List<Compte> getCompteByIdCLient(int id_client) {
		
		Query query = em.createNamedQuery("getCompteByIdClient");
		query.setParameter("id",id_client);
		
		return query.getResultList();
	}
}
