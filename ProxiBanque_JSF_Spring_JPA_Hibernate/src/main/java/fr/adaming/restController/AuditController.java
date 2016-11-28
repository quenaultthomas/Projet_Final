package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@RestController
public class AuditController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	IClientService clientService;
	
	@Autowired
	ICompteService compteService;
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
	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @param compteService the compteService to set
	 */
	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@RequestMapping(value="/allClient", method=RequestMethod.GET, produces="application/json")
	public List<Client> getAllClient(){
		
		return clientService.getAllClientService();
	}
	
	@RequestMapping(value="/allCompte", method=RequestMethod.GET, produces="application/json")
	public List<Compte> getAllCompte(){
		
		return compteService.getAllCompte();
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

	

	

}
