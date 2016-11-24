package fr.adaming.serviceTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.ICompteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class CompteServiceTest {

	@Autowired
	ICompteService compteService;
	
	
	@Test
	public void testGetAllCompte(){
		System.out.println("je suis dans la methode testGetAllCompte");
		assertEquals(1, compteService.getAllCompte().size());
	}
}
