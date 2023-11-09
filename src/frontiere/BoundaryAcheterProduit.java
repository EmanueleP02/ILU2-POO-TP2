package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
    private Scanner scanner;
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
        this.scanner = new Scanner(System.in);
    }

    public void acheterProduit(String nomAcheteur) {
        if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
            System.out.println("Quel produit voulez-vous acheter ?");
            String produit = scanner.nextLine();

            if (controlAcheterProduit.verifierDisponibilite(produit)) {
                System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
                String[] etatMarche = controlAcheterProduit.donnerEtatMarche();
                for (int i = 0; i < etatMarche.length; i += 3) {
                    if (etatMarche[i + 2].equals(produit)) {
                        System.out.println((i / 3 + 1) + " - " + etatMarche[i]);
                    }
                }

                int choixVendeur = scanner.nextInt();
                String nomVendeur = etatMarche[(choixVendeur - 1) * 3];
                int quantiteAcheter;

                Etal etal = controlAcheterProduit.recupEtal(nomVendeur);
                System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);

                System.out.println("Bonjour " + nomAcheteur);
                System.out.println("Combien de " + produit + " voulez-vous acheter ?");
                quantiteAcheter = scanner.nextInt();

                int quantiteVoulue = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAcheter);

                if (quantiteVoulue == 0) {
                    System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit + ", " +
                            "malheureusement il n'y en a plus !");
                } else if (quantiteVoulue < quantiteAcheter) {
                    System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit + ", " +
                            "malheureusement " + nomVendeur + " n'en a plus que " + quantiteVoulue + ". " +
                            nomAcheteur + " achète tout le stock de " + nomVendeur);
                } else {
                    System.out.println(nomAcheteur + " achète " + quantiteAcheter + " " + produit + " à " + nomVendeur);
                }
            } else {
                System.out.println("Désolé, personne ne vend ce produit au marché.");
            }
        } else {
            System.out.println("Je suis désolé " + nomAcheteur +
                    " mais il faut être un habitant de notre village pour acheter un produit.");
        }
    }
}

