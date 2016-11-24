package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Carte;
import fr.adaming.model.Compte;

@Repository
public class CarteDaoImpl implements ICarteDao {

	@PersistenceContext(unitName="ProxyBanque")
	EntityManager em;
	
	@Override
	public void AjouterCarte(Carte carte) {
		
		em.persist(carte);
		
	}

	@Override
	public void ModifierCarte(Carte carte) {
		
		
		Carte mergeCarte = em.find(Carte.class, carte.getId_carte());
		
		
		
	}

	@Override
	public void SupprimerCarte(Carte carte) {
		// Récupérer un user de l'id 6
					Compte delCarte = em.find(Compte.class, carte.getId_carte());
					
					// supprimer l'objet u
					em.remove(delCarte);
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
