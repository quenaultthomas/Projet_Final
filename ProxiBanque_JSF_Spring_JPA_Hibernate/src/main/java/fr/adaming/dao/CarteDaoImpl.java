package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Carte;
import fr.adaming.model.Compte;

@Repository
public class CarteDaoImpl implements ICarteDao {

	@Override
	public void AjouterCarte(Carte carte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(carte);
		
	}

	@Override
	public void ModifierCarte(Carte carte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Carte mergeCarte = em.find(Carte.class, carte.getId_carte());
		
		
	}

	@Override
	public void SupprimerCarte(Carte carte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProxyBanque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Récupérer un user de l'id 6
		Compte delCarte = em.find(Compte.class, carte.getId_carte());
		
		// supprimer l'objet u
		em.remove(delCarte);

		tx.commit();
		em.close();
		emf.close();
	}
		
	

	@Override
	public Compte getCarteById(int id_carte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getAllCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
