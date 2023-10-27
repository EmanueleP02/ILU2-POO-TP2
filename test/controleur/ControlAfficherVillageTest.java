package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	@BeforeEach
	public void initialiserStatut() {
		village=new Village("Le village des irréductibles",10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	@Test
	void testnomVillage() {
		ControlAfficherVillage ctrlAfficherVillage = new ControlAfficherVillage(village);
		String nomVillage = ctrlAfficherVillage.donnerNomVillage();
		assertTrue(nomVillage.equals("Le village des irréductibles"));
	}
	@Test
	void testnbEtals() {
		ControlAfficherVillage ctrlAfficherVillage = new ControlAfficherVillage(village);
		assertTrue(ctrlAfficherVillage.donnerNbEtals()==0);
	}
	@Test
	void testnomsVillageois() {
		ControlAfficherVillage ctrlAfficherVillage = new ControlAfficherVillage(village);
		String[] nomsVillageois = ctrlAfficherVillage.donnerNomsVillageois();
		assertTrue(nomsVillageois[0].equals("Abracourcix"));
	}
}
