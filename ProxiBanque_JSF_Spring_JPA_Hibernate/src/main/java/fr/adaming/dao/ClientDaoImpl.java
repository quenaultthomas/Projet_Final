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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@PersistenceContext(name="ProxyBanque")
	EntityManager em;
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

		//Instanciation d'un objet utilisation
		em.persist(client);
		

	}

	@Override
	public void updateClientDao(Client client) {
		//Instanciation d'un objet utilisation
		em.merge(client);

	}

	@Override
	public void deleteClientDao(int id_client) {
		//Récupérer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);
		
		//Supprimer l'objet user
		em.remove(client);
		
	}

	@Override
	public List<Client> getAllClientDao() {

		String req = "SELECT * FROM Client c";
		Query query1 = em.createNativeQuery("req");
		List<Client> liste = query1.getResultList();
		
		return liste;
	}

	@Override
	public Client getClientByIdDao(int id_client) {
		//Récupérer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);

		return client;
	}
	
	@Override
	public int isExistClientDao(String mail, String password) {
		String req="SELECT * FROM client c WHERE c.mail=:mail and c.password=:password";
		
		Query query =em.createNativeQuery(req);
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<Client> listeClient = query.getResultList();
				
		return listeClient.size();
	}
	
	public List<Client> getClientsByIdGestionnaireDao(int id_gest){
		String req="SELECT * FROM client c WHERE c.id_gestionnaire=:id_gest";
		
		Query query =em.createNativeQuery(req);
		query.setParameter("id_gest", id_gest);
		
		return query.getResultList();
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------




}
