/**
 * 
 * @author CLAIN Fabien
 * Date :24/11/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
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
	public int isExistClientDao(String mail,String password);
	public void addClientDao(Client client);
	public void updateClientDao(Client client);
	public void deleteClientDao(int id_client);
	public List<Client> getAllClientDao();
	public Client getClientByIdDao(int id_client);
	public List<Client> getClientsByIdGestionnaireDao(int id_client);
	public Client getClientByIdentifiantDao(String mail,String password);
	public Client getClientByNomPrenom (String nom, String prenom);
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
