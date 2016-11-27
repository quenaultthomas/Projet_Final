/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Gestionnaire;

/**
 * @author inti0304
 *
 */

@Repository
public class GestionaireDaoImpl implements IGestionnaireDao {
	
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
	public int isExistGestionnaireDao(String login, String password) {
	
	System.out.println("Toto");
	
	String req="SELECT * FROM gestionnaire as g WHERE g.login =:login and g.password=:password";
	
	Query queryGestionnaireIsExist = em.createNativeQuery(req);
	queryGestionnaireIsExist.setParameter("login",login);
	queryGestionnaireIsExist.setParameter("password",password);
	
	@SuppressWarnings("unchecked")
	List<Gestionnaire> listeGestionnaire = queryGestionnaireIsExist.getResultList();
			System.out.println(listeGestionnaire.size());
	return listeGestionnaire.size();
}
	@Override
	public Gestionnaire getGestByIdentificationDao(String login, String password) {
		String req="SELECT g FROM Gestionnaire g WHERE g.login=:login and g.password=:password";
		
		Query query =em.createQuery(req);
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		Gestionnaire gestionnaire =  (Gestionnaire) query.getSingleResult();
		return gestionnaire;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gestionnaire> getAllGestionnaires() {
		String req="SELECT g FROM Gestionnaire g";
		Query query =em.createQuery(req);		
		return query.getResultList();
	}
	
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
	

	


}
