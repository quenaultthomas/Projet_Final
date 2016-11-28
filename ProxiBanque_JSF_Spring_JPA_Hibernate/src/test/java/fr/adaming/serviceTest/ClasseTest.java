package fr.adaming.serviceTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

public class ClasseTest {

	public static void main(String[] args) {
		String configLocation = "C:\\Users\\inti0292\\git\\Projet_Final_v2\\ProxiBanque_JSF_Spring_JPA_Hibernate\\src\\main\\webapp\\WEB-INF\\application-context.xml";

		ApplicationContext cxt = new FileSystemXmlApplicationContext(configLocation);

		 ICompteService compteService = (ICompteService)
		 cxt.getBean("compteService");
		
//		 IClientService clientService = (IClientService) cxt.getBean("clientService");
//		 
//		 Client cl = clientService.getClientByIdService(1);
//		 
//		 
//		 
//		 Compte cmpt = new Compte("1", "ccc", 100, -100, 1);
//		 cmpt.setClient(cl);
//		 
//		 compteService.AjouterCompte(cmpt);
//		 
//		 
//		 Compte cmpt2 = new Compte(6,"sfdsf", "ccc", 100, -100, 1);
//		 //compteService.SupprimerCompte(cmpt2);
//		 compteService.ModifierCompte(cmpt2);
//		 
//		 compteService.depot(1, 1);
//		 
//		 compteService.retrait(100, 4);
//		 
//		 compteService.virement(100, 7, 8);
//		 
		 List<Compte> liste = compteService.getAllCompte();
		
		 for (Compte compte : liste) {
		 System.out.println(compte);
		 }
//		 
//		 Compte c = compteService.getCompteById(1);
//		 
//		 List<Compte> liste1 = compteService.getCompteByIdCLient(1);
//		System.out.println("Liste des comptes du client id=1");
//		 for (Compte compte : liste1) {
//			 System.out.println(compte);
//			 }
//
//		 compteService.depot(1, 1);
		 
	}

}
