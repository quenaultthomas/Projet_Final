//package fr.adaming.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Calendar;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.model.Compte;
//import fr.adaming.model.Operation;
//import fr.adaming.service.IOperationService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
//public class OperationServiceTest {
//
//	@Autowired
//	IOperationService operationService;
//	
//	@Test
//	public void testAjouterOperation(){
//		Calendar c = Calendar.getInstance();
//		
//		System.out.println("je suis dans la methode testAjouterOperation");
//		Operation operation = new Operation("Virement", 1200, c.getTime());
//		Compte compte = new Compte();
//		compte.setId_compte(1);
//		operation.setCompte(compte);
//		operationService.ajouterOperationService(operation);
//		assertEquals(1, operationService.getOperationsByIdCompteService(1).size());
//	}
//}
