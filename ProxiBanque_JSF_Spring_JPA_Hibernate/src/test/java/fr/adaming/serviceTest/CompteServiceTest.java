package fr.adaming.serviceTest;

import static org.junit.Assert.*;
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
		assertEquals(11, compteService.getAllCompte().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCompteById(){
		System.out.println("je suis dans la methode testGetCompteById");
		
		assertEquals("1", compteService.getCompteById(1).getNumero());
	}	
	
	@Test
	public void testAjouterCompte(){
		System.out.println("je suis dans la methode testGetAjouterCompte");
		 Compte cmpt = new Compte("1", "ccc", 100, -100, 1);
		compteService.AjouterCompte(cmpt);
		assertEquals(11, compteService.getAllCompte().size());
	}
}
