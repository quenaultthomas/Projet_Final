package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Operation;

@Repository
public class OperationDaoImpl implements IOperationDao {

	@PersistenceContext(name="ProxyBanque")
	EntityManager em;

	/**
	 * Methode pour recherhcer une operation par l'ID du compte
	 * Retourne une liste d'operation
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getOperationsByIdCompte(int id_compte) {
		Query query = em.createNamedQuery("getOperationsByIdCompte");
		query.setParameter("id_compte", id_compte);
		return query.getResultList();
	}
	/**
	 * Methode pour ajouter une operation
	 * Retourne un void
	 */
	@Override
	public void ajouterOperation(Operation operation) {
		em.persist(operation);
	}

}
