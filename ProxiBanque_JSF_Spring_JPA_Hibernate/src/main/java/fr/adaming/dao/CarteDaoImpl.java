package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Carte;
import fr.adaming.model.Compte;

@Repository
public class CarteDaoImpl implements ICarteDao {

	@Autowired
	EntityManager em;
	
	@Override
	public void AjouterCarte(Carte carte) {
		
		em.persist(carte);
		
	}

	@Override
	public void ModifierCarte(Carte carte) {
		
		
		Carte mergeCarte = em.find(Carte.class, carte.getId_carte());
		
		//Modification des parametres de la table 
				mergeCarte.setNumCarte(carte.getNumCarte());
				mergeCarte.setNomtitulaire(carte.getNomtitulaire());
				mergeCarte.setTypeCarte(carte.getTypeCarte());
				mergeCarte.setPlafond(carte.getPlafond());
				em.merge(mergeCarte);
		
	}

	@Override
	public void SupprimerCarte(Carte carte) {
		// Récupérer un user de l'id 6
					Compte delCarte = em.find(Compte.class, carte.getId_carte());
					
					// supprimer l'objet u
					em.remove(delCarte);
	}
		
	

	@Override
	public Carte getCarteById(int id_carte) {
Query query = em.createNamedQuery("getCompteById");
		
		return (Carte) query.getSingleResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carte> getAllCarte() {
Query query = em.createNamedQuery("getAllCompte");
		
		return query.getResultList();
	}

	
}
