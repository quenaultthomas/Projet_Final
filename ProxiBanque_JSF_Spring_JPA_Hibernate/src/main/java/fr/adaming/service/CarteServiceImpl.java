package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICarteDao;
import fr.adaming.model.Carte;

@Service("carteService")
@Transactional
public class CarteServiceImpl implements ICarteService {

	@Autowired
	ICarteDao carteDao;
	
	@Override
	public void AjouterCarteService(Carte carte) {
		carteDao.AjouterCarte(carte);

	}

	@Override
	public void ModifierCarteService(Carte carte) {
		carteDao.ModifierCarte(carte);

	}

	@Override
	public void SupprimerCarteService(Carte carte) {
		carteDao.SupprimerCarte(carte);

	}

	@Override
	public Carte getCarteByIdService(int id_carte) {
		
		return carteDao.getCarteById(id_carte);
	}

	@Override
	public List<Carte> getAllCarteService() {
		
		return carteDao.getAllCarte();
	}

}
