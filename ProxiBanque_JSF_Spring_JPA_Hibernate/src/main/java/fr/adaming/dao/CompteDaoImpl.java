package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Compte;
/**
 * 
 * @author inti0292
 *
 *Classe CompteDaoImpl qui impl�mente l'interface ICompteDao
 */
@Repository
public class CompteDaoImpl implements ICompteDao {

	/**
	 * Injection dependance de l'entityManager
	 */
	@PersistenceContext(name="ProxyBanque")
	EntityManager em;
	
	/**
	 * D�claration de la m�thode ajouter Compte
	 * 
	 * methode permettant l'ajout d'un compte dans la base de donn�es
	 */
	@Override
	public void AjouterCompte(Compte compte) {
		
	em.persist(compte);
	
	}

	/**
	 * D�claration de la m�thode modifier Compte
	 * 
	 * methode permettant la modification d'un compte dans la base de donn�es
	 */
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

	/**
	 * D�claration de la m�thode supprimer Compte
	 * 
	 * methode permettant la suppression d'un compte dans la base de donn�es
	 */
	@Override
	public void SupprimerCompte(Compte compte) {

			// R�cup�rer un user de l'id 6
			Compte delCompte = em.find(Compte.class, compte.getId_compte());
			
			// supprimer l'objet u
			em.remove(delCompte);

		}
		
	
	/**
	 * D�claration de la m�thode getCompteById
	 * 
	 * methode permettant la recherche d'un compte dans la base de donn�es par son id
	 */
	@Override
	public Compte getCompteById(int id_compte) {
				
		Query query = em.createNamedQuery("getCompteById");
		query.setParameter("id",id_compte);
		
		return (Compte) query.getSingleResult();
	}


	/**
	 * D�claration de la m�thode getAllCompte
	 * 
	 * methode permettant la recherche des comptes dans la base de donn�es 
	 */
	@Override
	public List<Compte> getAllCompte() {
		
		Query query = em.createNamedQuery("getAllCompte");
		
		return query.getResultList();
	}	
	

	/**
	 * D�claration de la m�thode depot
	 * 
	 * methode permettant l'op�ration de d�pose d'argent sur un compte
	 */
	@Override
	public void depot(double montant, int id_compteC) {
		Compte c = this.getCompteById(id_compteC);
		double compteSolde=c.getSolde() ;
		compteSolde= compteSolde+montant;

		c.setSolde(compteSolde);
		this.ModifierCompte(c);
		
	}

	/**
	 * D�claration de la m�thode retrait
	 * 
	 * methode permettant l'op�ration de retrait d'argent sur un compte
	 */
	@Override
	public void retrait(double montant, int id_compteD) {
		
		Compte debit = this.getCompteById(id_compteD);
		double compteSolde=debit.getSolde() ;
		
		compteSolde= compteSolde-montant;
		
		if(compteSolde<debit.getDecouvert()){
			//throw new ExceptionMontant("Impossible, le montant demand� est sup�rieur au solde disponible sur ce compte");
		}else{
		debit.setSolde(compteSolde);
		this.ModifierCompte(debit);
		
		}
		
	}

	/**
	 * D�claration de la m�thode depot
	 * 
	 * methode permettant l'op�ration de virement d'argent de compte � compte
	 */
	@Override
	public void virement(double montant, int id_compteD, int id_compteC)  {
		
		Compte debit = this.getCompteById(id_compteD);
		double compteSolde=debit.getSolde() ;
		
		compteSolde= compteSolde-montant;
		
		if(compteSolde<debit.getDecouvert()){
			//throw new ExceptionMontant("Impossible, le montant demand� est sup�rieur au solde disponible sur ce compte");
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

	/**
	 * D�claration de la m�thode getCompteByIdClient
	 * 
	 * methode permettant la recherche des comptes de chaque client par l'id de celui-ci
	 */
	@Override
	public List<Compte> getCompteByIdCLient(int id_client) {
		
		Query query = em.createNamedQuery("getCompteByIdClient");
		query.setParameter("id",id_client);
		
		return query.getResultList();
	}
}
