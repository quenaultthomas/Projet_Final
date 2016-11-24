/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------

	
	@Override
	public int isExistGestionnaireDao(String login, String password) {
		
		//Créer l'Entity Manager Factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
		
		//Créer un Entity Manager
		EntityManager em = emf.createEntityManager();
		
		String req="Select g From gestionnaire g where g.login=:login and g.password=:password";
		
		Query queryGestionnaireIsExist = em.createNativeQuery(req);
		queryGestionnaireIsExist.setParameter("login",login);
		queryGestionnaireIsExist.setParameter("password",password);
		
		@SuppressWarnings("unchecked")
		List<Gestionnaire> listeGestionnaire = queryGestionnaireIsExist.getResultList();
				
		return listeGestionnaire.size();
	}

}
