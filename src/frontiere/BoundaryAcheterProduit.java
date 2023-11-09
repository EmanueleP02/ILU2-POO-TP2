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
	    if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
	        System.out.println("Quel produit voulez-vous acheter ?");
	        String produit = scan.next();

	        if (controlAcheterProduit.verifierDisponibilite(produit)) {
	            String[] vendeurs = [];
	            if (vendeurs.length == 0) {
	                System.out.println("Désolé, personne ne vend ce produit au marché.");
	            } else {
	            	
	                System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
	                for (int i = 0; i < vendeurs.length; i++) {
	                    System.out.println((i + 1) + " - " + vendeurs[i]);
	                }

	                int choix = scan.nextInt();
	                String nomVendeur = vendeurs[choix - 1];

	                System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
	                System.out.println("Bonjour " + nomAcheteur);
	                System.out.println("Combien de " + produit + " voulez-vous acheter ?");
	                int quantite = scan.nextInt();

	                if (quantite > 0) {
	                    if (quantite > 3) {
	                        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + nomVendeur + " n'en a plus que 3. " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
	                        
	                    } else if (quantite <= 3) {
	                        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");

	                    }
	                } else {
	                    System.out.println(nomAcheteur + " veut acheter une quantité non valide.");
	                }
	            }
	        } else {
	            System.out.println("Désolé, personne ne vend ce produit au marché.");
	        }
	    } else {
	        System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour acheter un produit.");
	    }
    }
}
