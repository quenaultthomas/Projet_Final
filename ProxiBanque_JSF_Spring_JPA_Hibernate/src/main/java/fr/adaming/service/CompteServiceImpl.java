package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Compte;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteDao compteDao;
	
	@Override
	public void AjouterCompte(Compte compte) {
		compteDao.AjouterCompte(compte);

	}

	@Override
	public void ModifierCompte(Compte compte) {
		compteDao.ModifierCompte(compte);

	}

	@Override
	public void SupprimerCompte(Compte compte) {
		compteDao.SupprimerCompte(compte);

	}

	@Override
	public Compte getCompteById(int id_compte) {
		return compteDao.getCompteById(id_compte);
	}

	@Override
	public List<Compte> getAllCompte() {
		return compteDao.getAllCompte();
	}

	@Override
	public void virement(double montant, int id_compteD, int id_compteC) {
		compteDao.virement(montant, id_compteD, id_compteC);
		
	}

	@Override
	public void retrait(double montant, int id_compteD) {
		compteDao.retrait(montant, id_compteD);
		
	}

	@Override
	public void depot(double montant, int id_compteC) {
		compteDao.depot(montant, id_compteC);
		
	}

	
}
