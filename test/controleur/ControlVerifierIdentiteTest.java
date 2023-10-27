package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiserStatut() {
		village=new Village("Le village des irréductibles",10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	@Test
	void testverifierIdentite() {
		ControlVerifierIdentite ctrlIdentite = new ControlVerifierIdentite(village);
		assertTrue(ctrlIdentite.verifierIdentite("Abracourcix"));
		assertFalse(ctrlIdentite.verifierIdentite("Bonemine"));
	}

}
