package fr.adaming.daoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import fr.adaming.model.Client;
import fr.adaming.service.IClientService;


public class AA {
	public static void main(String[] args) {
		String configLocation = "C:\\Users\\inti0293\\git\\Projet_Final3\\ProxiBanque_JSF_Spring_JPA_Hibernate\\src\\main\\webapp\\WEB-INF\\application-context.xml";

		ApplicationContext cxt = new FileSystemXmlApplicationContext(configLocation);

		
		 IClientService clientService = (IClientService) cxt.getBean("clientService");
		
//		Client client = new Client("toto", "a", "a", "a", 0, "a", "a@a", "a", new byte[0], "a");
//		System.out.println(client);
//		clientService.addClientService(client);
		
		
//		 Client client = clientService.getClientByIdService(1);
//		 
//		 client.setNom("TOTO");
//		 client.setPrenom("L'asticot");
//		 
//		 clientService.updateClientService(client);
//		 
//		 Client client2 = clientService.getClientByIdService(1);
//		 System.out.println(client2);
//		 clientService.deleteClientService(1);
		 System.out.println(clientService.getClientByIdentifiantService("a@a", "a"));
	}
}
