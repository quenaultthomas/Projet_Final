/**
 * 
 * @author CLAIN Fabien
 * Date :24/11/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

public class ClientServiceImpl implements IClientService {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	IClientDao clientDao;
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
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@Override
	public void addClientService(Client client) {
		clientDao.addClientDao(client);

	}

	@Override
	public void updateClientService(Client client) {
		clientDao.updateClientDao(client);

	}

	@Override
	public void deleteClientService(int id_client) {
		clientDao.deleteClientDao(id_client);

	}

	@Override
	public List<Client> getAllClientService() {
		return clientDao.getAllClientDao();
	}

	@Override
	public Client getClientByIdService(int id_client) {
		return clientDao.getClientByIdDao(id_client);
	}
	
	@Override
	public int isExistClientService(String mail, String password) {
		return clientDao.isExistClientDao(mail, password);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------



}
