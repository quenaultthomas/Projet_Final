package fr.adaming.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Audit;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Gestionnaire;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IGestionnaireService;

@RestController
public class AuditController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
	/**
	 * R�cup�ration des m�thodes du client, compte et gestionnaire
	 */
	@Autowired
	IClientService clientService;
	
	@Autowired
	ICompteService compteService;
	
	@Autowired
	IGestionnaireService gestionService;
	
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
	
	/**
	 * @param gestionService the gestionService to set
	 */
	public void setGestionService(IGestionnaireService gestionService) {
		this.gestionService = gestionService;
	}

	//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	/**
	 * R�cup�ration de tous les clients en format json
	 */
	@RequestMapping(value="/allClient", method=RequestMethod.GET, produces="application/json")
	public List<Client> getAllClient(){
		
		return clientService.getAllClientService();
	}
	
	/**
	 * R�cup�ration du nombre de clients
	 */
	@RequestMapping(value="/nombreClient", method=RequestMethod.GET, produces="application/json")
	public int nombreClient(){
		
		return clientService.getAllClientService().size();
	}
	
	/**
	 * R�cup�ration de tous les comptes en format json
	 */
	@RequestMapping(value="/allCompte", method=RequestMethod.GET, produces="application/json")
	public List<Compte> getAllCompte(){
		
		return compteService.getAllCompte();
	}
	
	/**
	 * R�cup�ration du nombre de comptes
	 */
	@RequestMapping(value="/nombreCompte", method=RequestMethod.GET, produces="application/json")
	public int nombreCompte(){
		
		return compteService.getAllCompte().size();
	}
	
	/**
	 * R�cup�ration de tous les comptes en n�gatif en format json
	 */
	
	@RequestMapping(value="/allCompteDecouvert", method=RequestMethod.GET, produces="application/json")
	public List<Compte> getAllCompteDecouvert(){
		
		List<Compte> listeDecouvert = new ArrayList<>();
		
		List<Compte> listeCompte = compteService.getAllCompte();
		
		for (Compte compte : listeCompte) {
			if(compte.getSolde()<0){
				listeDecouvert.add(compte);
			}
		}
		
		return listeDecouvert;
	}
	
	/**
	 * R�cup�ration de tous les gestionnaires
	 */
	
	@RequestMapping(value="/allGestion", method=RequestMethod.GET, produces="application/json")
	public List<Gestionnaire> getAllGestion(){
		
		return gestionService.getAllGestionnairesService();
	}
	
	/**
	 * R�cup�ration du nombre de gestionnaires
	 */
	
	@RequestMapping(value="/nombreGestion", method=RequestMethod.GET, produces="application/json")
	public int nombreGestion(){
		
		return gestionService.getAllGestionnairesService().size();
	}
	
	/**
	 * R�cup�ration du nombre de comptes en n�gatif
	 */
	
	@RequestMapping(value="/nombreDecouvert", method=RequestMethod.GET, produces="application/json")
	public int nombreCompteDecouvert(){
		
		List<Compte> listeDecouvert = new ArrayList<>();
		
		List<Compte> listeCompte = compteService.getAllCompte();
		
		for (Compte compte : listeCompte) {
			if(compte.getSolde()<0){
				listeDecouvert.add(compte);
			}
		}
		
		return listeDecouvert.size();
	}
	
	/**
	 * R�cup�ration des comptes � d�couvert
	 */
	
	@RequestMapping(value="/allCompteTresDecouvert", method=RequestMethod.GET, produces="application/json")
	public List<Compte> getAllCompteTresDecouvert(){
		
		List<Compte> listeTresDecouvert = new ArrayList<>();
		
		List<Compte> listeCompte = compteService.getAllCompte();
		
		for (Compte compte : listeCompte) {
			if(compte.getSolde()<compte.getDecouvert()){
				listeTresDecouvert.add(compte);
			}
		}
		
		return listeTresDecouvert;
	}
	
	/**
	 * R�cup�ration du nombre de comptes sous le d�couvert autoris�
	 */
	
	@RequestMapping(value="/nombreTresDecouvert", method=RequestMethod.GET, produces="application/json")
	public int nombreCompteTresDecouvert(){
		
		List<Compte> listeDecouvert = new ArrayList<>();
		
		List<Compte> listeCompte = compteService.getAllCompte();
		
		for (Compte compte : listeCompte) {
			if(compte.getSolde()<compte.getDecouvert()){
				listeDecouvert.add(compte);
			}
		}
		
		return listeDecouvert.size();
	}
	
	/**
	 * R�cup�ration du bilan pour l'audit
	 */
	
	@RequestMapping(value="/bilan", method=RequestMethod.GET, produces="application/json")
	public Audit bilan(){
		
		Audit audit = new Audit();
		
		int nbG = nombreGestion();
		audit.setNbGestion(nbG);
		
		int nbC = nombreClient();
		audit.setNbClient(nbC);
		
		double pourcentDecouvert = (double)nombreCompteDecouvert()/nombreCompte();
		audit.setTauxDecouvert(pourcentDecouvert);
		
		double pourcentSousDecouvert = (double)nombreCompteTresDecouvert()/nombreClient();
		audit.setSousDecouvert(pourcentSousDecouvert);
		
		List<Compte> listeDecouvert = getAllCompteDecouvert();
		audit.setListCompteDecouvert(listeDecouvert);
		
		return audit;
		
	}
	
	/**
	 * R�cup�ration des clients par gestionnaire
	 */
	
	@RequestMapping(value="/allClientGest/{id_gest}", method=RequestMethod.GET, produces="application/json")
	public List<Client> getAllClientByGest(@PathVariable("id_gest") int id_gest){
				
		List<Client> listeClient = clientService.getClientsByIdGestionnaireService(id_gest);
		
		return listeClient;
	}
	
	/**
	 * R�cup�ration du nombre de client par gestionnaire
	 */
	
	@RequestMapping(value="/nombreClientGest/{id_gest}", method=RequestMethod.GET, produces="application/json")
	public int nombreClientByGest(@PathVariable("id_gest") int id_gest){
				
		List<Client> listeClient = clientService.getClientsByIdGestionnaireService(id_gest);
		
		return listeClient.size();
	}
	
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
