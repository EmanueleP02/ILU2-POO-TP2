package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef chef;
	@BeforeEach
	public void initialiserStatut() {
		village=new Village("Le village des irréductibles",10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	@Test
	void testIsVendeur() {
		ControlLibererEtal ctrlLibererEtal = new ControlLibererEtal();
	}

}
