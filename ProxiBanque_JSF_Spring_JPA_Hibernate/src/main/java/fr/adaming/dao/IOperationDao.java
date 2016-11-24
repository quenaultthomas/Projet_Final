package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Operation;

public interface IOperationDao {
	
	public List<Operation> getOperationsByIdCompte(int id_compte);
	
	public void ajouterOperation(Operation operation);

}
