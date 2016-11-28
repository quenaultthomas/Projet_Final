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
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	ICompteService compteService;
	
	@RequestMapping(value="/allClient", method=RequestMethod.GET, produces="application/json")
	public List<Client> getAllClient(){
		
		return clientService.getAllClientService();
	}
	
	@RequestMapping(value="/allCompte", method=RequestMethod.GET, produces="application/json")
	public List<Compte> getAllCompte(){
		
		return compteService.getAllCompte();
	}
	

}
