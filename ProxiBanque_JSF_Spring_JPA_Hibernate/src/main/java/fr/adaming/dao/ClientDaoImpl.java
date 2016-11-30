/**
 * 
 * @author CLAIN Fabien
 * Date :24/11/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	/**
	 * Méthode addClientDao permet d'ajouter un client dans la database
	 * 
	 * Aucun retour
	 */
	@Override
	public void addClientDao(Client client) {		

		//Instanciation d'un objet utilisation
		em.persist(client);

	}

	/**
	 * Méthode updateClientDao permet de mettre à jour un client dans la database
	 * 
	 * Aucun retour
	 */
	@Override
	public void updateClientDao(Client client) {
		//Instanciation d'un objet utilisation
		em.merge(client);

	}
	
	/**
	 * Méthode updateClientDao permet de mettre à jour un client dans la database
	 * 
	 * Aucun retour
	 */
	@Override
	public void deleteClientDao(int id_client) {
		//Récupérer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);
		
		//Supprimer l'objet user
		em.remove(client);
		
	}
	
	/**
	 * Méthode getAllClientDao permet de récuperer tous les clients de la database
	 * 
	 * Retourne une liste de client("List<Client>")
	 */
	@Override
	public List<Client> getAllClientDao() {

		String req = "SELECT c FROM Client c";
		Query query1 = em.createQuery(req);
		List<Client> liste = query1.getResultList();
		
		return liste;
	}

	/**
	 * Méthode getClientByIdDao permet de récuperer un client de la database avec sont Id
	 * 
	 * Retourne un objet client
	 */
	@Override
	public Client getClientByIdDao(int id_client) {
		//Récupérer un utilisateur par sont ID
		Client client = em.find(Client.class, id_client);

		return client;
	}
	
	/**
	 * Méthode isExistClientDao permet de vérifier si les identifiants existent dans la database
	 * 
	 * Retourne int (si le client existe le retour est 1 sinon 0)
	 */
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
	
	/**
	 * Méthode getClientByIdGestionnaireDao permet de récupérer tout les clients d'un gestionnaire grace à son Id
	 * 
	 * Retourne une liste de client("List<Client>")
	 */
	public List<Client> getClientsByIdGestionnaireDao(int id_gest){
		String req="SELECT c FROM Client c WHERE c.gestionnaire.id_gestionnaire=:id_gest";
		
		Query query =em.createQuery(req);
		query.setParameter("id_gest", id_gest);
		
		return query.getResultList();
	}
	
	/**
	 * Méthode getClientByIdentificationDao permet de récupérer un client grace à ses identifiants 
	 * 
	 * Retourne un objet client
	 */
	@Override
	public Client getClientByIdentifiantDao(String mail, String password) {
		String req="SELECT c FROM Client c WHERE c.mail=:mail and c.password=:password";
		
		Query query =em.createQuery(req);
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		
		Client client = (Client) query.getSingleResult();
		return client;
	}
	
	/**
	 * Méthode getClientByNomPrenom permet de récupérer un client grace à son nom et prenom 
	 * 
	 * Retourne un objet client
	 */
	@Override
	public Client getClientByNomPrenom(String nom, String prenom) {
	String req="SELECT c FROM Client c WHERE c.nom=:nom and c.prenom=:prenom";
		
		Query query =em.createQuery(req);
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		
		Client client = (Client) query.getSingleResult();
		return client;
	}

	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------

}
