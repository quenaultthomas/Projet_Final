package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Operation;

public interface IOperationService {

	public List<Operation> getOperationsByIdCompteService(int id_compte);

	public void ajouterOperationService(Operation operation);

}
