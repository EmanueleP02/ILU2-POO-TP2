package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	public String[] donnerEtatMarche() {
		return village.donnerEtatMarche();
	}
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	public Etal recupEtal(String nomVendeur) {
        return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
    }
	public int acheterProduit(String nomVendeur,int nbProduit) {
        Etal etal = recupEtal(nomVendeur);
        return etal.acheterProduit(nbProduit);
    }
	public boolean verifierDisponibilite(String produit) {
	    String[] etatMarche = village.donnerEtatMarche();
	    for (int i = 0; i < etatMarche.length; i += 3) {
	        String produitVende = etatMarche[i + 2];

	        if (produitVende.equals(produit)) {
	            return true;
	        }
	    }
	    return false;
	}
}
