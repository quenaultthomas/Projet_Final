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
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
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
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@Override
	public void addClientDao(Client client) {
		//Créer l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Créer un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Créer une transaction à partir de l'entityManager
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
		//Créer l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Créer un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Créer une transaction à partir de l'entityManager
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
		//Créer l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Créer un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Créer une transaction à partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//Récupérer un utilisateur par sont ID
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
		//Créer l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("PU");
		
		//Créer un entityManager
		EntityManager em=emf.createEntityManager();
		
		Query query1 = em.createNamedQuery("req1");
		List<Client> liste = query1.getResultList();
		
		return liste;
	}

	@Override
	public Client getClientByIdDao(int id_client) {
		//Créer l'entityManageFactory
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("ProxiBanque");
		
		//Créer un entityManager
		EntityManager em=emf.createEntityManager();
		
		//Créer une transaction à partir de l'entityManager
		EntityTransaction tx = em.getTransaction();
		
		//Ouvrir la transaction
		tx.begin();
		
		//Récupérer un utilisateur par sont ID
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
		//Créer l'entityManageFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxiBanque");
		//Créer un entityManager
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
