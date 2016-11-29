/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGestionnaireDao;
import fr.adaming.model.Gestionnaire;

/**
 * @author inti0304
 *
 */
@Service("gestionService")
@Transactional
public class GestionnaireServiceImpl implements IGestionnaireService {

// ----------------------------------------------------------------------------------------------------------------
// ---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
/**
 * 1_Les propri�t�s (champs, attributs)
 */

	@Autowired
	IGestionnaireDao gestionDao;

// ----------------------------------------------------------------------------------------------------------------
// ---------------------------------2_Les constructeurs------------------------------------------------------------
	/**
	 * 2_Les constructeurs
	 */
// ----------------------------------------------------------------------------------------------------------------
// ---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
// ----------------------------------------------------------------------------------------------------------------
// ---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	
	/**
	 * M�thodes isExist 
	 * Retourne un int 
	 */
	@Override
	public int isExistGestionnaireService(String login, String password) {
		
		return gestionDao.isExistGestionnaireDao(login, password);
	}

	/**
	 * M�thodes qui recupere le gestionniare par son id  
	 * Retourne un gestionnaire
	 */
	@Override
	public Gestionnaire getGestByIdentificationService(String login, String password) {
		return gestionDao.getGestByIdentificationDao(login, password);
	}
	
	/**
	 * M�thodes qui reucpere les gestionnaires 
	 * Retourne une liste de gestionnaire 
	 */
	@Override
	public List<Gestionnaire> getAllGestionnairesService() {
		return gestionDao.getAllGestionnaires();
	}
// ----------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------

	
}
