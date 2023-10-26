package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donneesMarche = controlAfficherMarche.donnerEtatMarche();
		if(donneesMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}
		else {
			System.out.println(nomAcheteur+", vous trouverez au marché");
			int i=0;
			while (i<donneesMarche.length) {
				System.out.println("- "+donneesMarche[i]+" qui vend "+donneesMarche[i+1]+" "+donneesMarche[i+2]);
				i+=3;
			}
		}
	}
}
