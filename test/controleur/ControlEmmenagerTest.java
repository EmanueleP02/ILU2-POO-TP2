package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

import personnages.Chef;


class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	
	
	@BeforeEach
	public void initialiserStatut() {
		village=new Village("Le village des irréductibles",10, 5);
		chef = new Chef("Abracourcix", 10, village);
		village.setChef(chef);
	}
	@Test
	void testAjouterGaulois() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		ctrlEmmenager.ajouterGaulois("Bonémine", 3);
		assertTrue(ctrlEmmenager.isHabitant("Bonémine"));
	}
	@Test
	void testAjouterDruide() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		ctrlEmmenager.ajouterDruide("Jesaispix", 5, 1, 7);
		assertTrue(ctrlEmmenager.isHabitant("Jesaispix"));
	}
	@Test
	void testisHabitant() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		ctrlEmmenager.ajouterGaulois("Bonémine", 5);
		assertTrue(ctrlEmmenager.isHabitant("Bonémine"));
		assertFalse(ctrlEmmenager.isHabitant("Jesaispix"));
	}
	

}
