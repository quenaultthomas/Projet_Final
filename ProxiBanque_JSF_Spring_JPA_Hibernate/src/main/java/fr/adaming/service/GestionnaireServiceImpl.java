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
// ---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
/**
 * 1_Les propriétés (champs, attributs)
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
// ---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@Override
	public int isExistGestionnaireService(String login, String password) {
		
		return gestionDao.isExistGestionnaireDao(login, password);
	}

	@Override
	public Gestionnaire getGestByIdentificationService(String login, String password) {
		return gestionDao.getGestByIdentificationDao(login, password);
	}
	
	@Override
	public List<Gestionnaire> getAllGestionnairesService() {
		return gestionDao.getAllGestionnaires();
	}
// ----------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------

	
}
