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
	// ---------------------------------1_Les propri�t�s (champs,
	// attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
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
	// ---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
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
