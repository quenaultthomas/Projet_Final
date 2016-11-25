package fr.adaming.serviceTest;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Compte;
import fr.adaming.service.ICompteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class CompteServiceTest {

	@Autowired
	ICompteService compteService;
	
	
	@Test
	public void testGetAllCompte(){
		System.out.println("je suis dans la methode testGetAllCompte");
		assertEquals(8, compteService.getAllCompte().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCompteById(){
		System.out.println("je suis dans la methode testGetCompteById");
		
		assertEquals("1", compteService.getCompteById(1).getNumero());
	
	}	
}
