/**
 * 
 * @author CLAIN Fabien
 * Date :24/11/2016
 * 
 */
package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class ClientServiceTest {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private IClientDao clientDao;
	
	private int id_client;
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
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
//	@Test
//	public void testGetAllClient(){
//		System.out.println("Test de la méthode GetAllClient");
//		List<Client> listeClient = clientDao.getAllClientDao();
//		
//		assertEquals(3, listeClient.size());
//
//	}
//	
//	@Test
//	public void testGetClientById(){
//		System.out.println("Test de la méthode GetClient by ID");
//		id_client=1;
//		Client client = clientDao.getClientByIdDao(id_client);
//		assertEquals(1, client.getId_client());
//	}
	
	@Test
	public void testAddClient(){
		System.out.println("Test de la méthode AddClient");
		List<Client> listeClient = clientDao.getAllClientDao();
		int i = listeClient.size();
		
		Client client = new Client("toto", "a", "a", "a", 0, "a", "a@a", "a", new byte[0], "a");
		clientDao.addClientDao(client);
		
		listeClient = clientDao.getAllClientDao();
		
		assertEquals(i+1, listeClient.size());
	}
	
//	@Test
//	public void testUpdateClient(){
//		System.out.println("Test de la méthode updateClient");
//		id_client=1;
//		Client client = clientDao.getClientByIdDao(id_client);
//		client.setNom("testUpdateClient");
//		
//		clientDao.updateClientDao(client);
//		
//		
//		client = clientDao.getClientByIdDao(id_client);
//		assertEquals("testUpdateClient", client.getNom());
//	}
//	
//	@Test
//	public void testDeleteClient(){
//		System.out.println("Test de la méthode deleteClient");
//		id_client=1;
//		
//		List<Client> listeClient = clientDao.getAllClientDao();
//		int i = listeClient.size();
//		
//		clientDao.deleteClientDao(id_client);
//		
//		listeClient = clientDao.getAllClientDao();
//		
//		assertEquals(i-1, listeClient.size());
//	}
	
	@Test
	public void testIsExistClient(){
		System.out.println("Test de la méthode isExistClient");
		
		assertEquals(1, clientDao.isExistClientDao("a@a", "a"));
	}
	

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


}
