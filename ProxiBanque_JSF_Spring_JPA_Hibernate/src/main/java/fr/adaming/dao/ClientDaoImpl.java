/**
 * 
 * @author CLAIN Fabien
 * Date :24/11/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.adaming.model.Client;


public class ClientDaoImpl implements IClientDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	@Override
	public void addClientDao(Client client) {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Cr�er un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Cr�er une transaction � partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//Instanciation d'un objet utilisation
		em.persist(client);
		
		//Commit
		tx.commit();
		
		//Fermer les les entitysmannager
		em.close();
		emf.close();
	}

	@Override
	public void updateClientDao(Client client) {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Cr�er un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Cr�er une transaction � partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//Instanciation d'un objet utilisation
		em.merge(client);
		
		//Commit
		tx.commit();
		
		//Fermer les les entitysmannager
		em.close();
		emf.close();

	}

	@Override
	public void deleteClientDao(int id_client) {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Cr�er un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Cr�er une transaction � partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//R�cup�rer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);
		
		//Supprimer l'objet user
		em.remove(client);
		
		//Commiter la transaction
		tx.commit();
		
		//fermer les flux 
		em.close();
		emf.close();
	}

	@Override
	public List<Client> getAllClientDao() {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("PU");
		
		//Cr�er un entityManager
		EntityManager em=emf.createEntityManager();
		
		Query query1 = em.createNamedQuery("req1");
		List<Client> liste = query1.getResultList();
		
		return liste;
	}

	@Override
	public Client getClientByIdDao(int id_client) {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Cr�er un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Cr�er une transaction � partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//R�cup�rer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);
		
		//Commiter la transaction
		tx.commit();
		
		//fermer les flux 
		em.close();
		emf.close();
		
		return client;
	}
	@Override
	public int isExistClientDao(String mail, String password) {
		//Cr�er l'entityManageFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxiBanque");
		//Cr�er un entityManager
		EntityManager em = emf.createEntityManager();
		
		String req="SELECT c FROM client c WHERE c.mail=:mail and c.password=:password";
		
		Query query =em.createNamedQuery(req);
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<Client> listeClient = query.getResultList();
				
		return listeClient.size();
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------




}
