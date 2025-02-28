package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			 System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux trouver un étal");
			 if (controlPrendreEtal.resteEtals()) {
				 installerVendeur(nomVendeur);
			 }
			 else {
				 System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étals qui ne soit pas déjà occupé");
			 }
		}
		else {
			 System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		System.out.println("Quel produit souhaitez-vous vendre ? ");
	    String produit = scan.next();
	    int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ? ");
	    int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
	    System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+(numeroEtal+1));
	}
}