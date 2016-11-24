package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOperationDao;
import fr.adaming.model.Operation;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements IOperationService {

	@Autowired
	private IOperationDao operationDao;

	@Override
	public List<Operation> getOperationsByIdCompteService(int id_compte) {
		return operationDao.getOperationsByIdCompte(id_compte);
	}

	@Override
	public void ajouterOperationService(Operation operation) {
		operationDao.ajouterOperation(operation);
	}

}
