/**
 * 
 */
package fr.adaming.service;

import org.springframework.stereotype.Service;

import fr.adaming.dao.IGestionnaireDao;

/**
 * @author inti0304
 *
 */
@Service
public class GestionnaireServiceImpl implements IGestionnaireService {

	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------1_Les propriétés (champs,
	// attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	
	IGestionnaireDao gestionDao;
	
	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------2_Les
	// constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */
	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------3_Les Getters et
	// Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
	// ----------------------------------------------------------------------------------------------------------------
	// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	// ----------------------------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.service.IGestionnaireService#isExistGestionnaireService(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public int isExistGestionnaireService(String login, String password) {
		
		return gestionDao.isExistGestionnaireDao(login, password);
	}

}
