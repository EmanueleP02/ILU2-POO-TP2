package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)){
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
		}
		else {
			System.out.println("Je suis désolé "+nomAcheteur+" mais il faut être un habitant de notre village pour acheter un produit.");
		}
	}
}
