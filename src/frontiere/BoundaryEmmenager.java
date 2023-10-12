package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 = new StringBuilder();
					question2.append("Bienvenue villageois ").append(nomVisiteur).append("\n");
					question2.append("Quelle est votre force?\n");
					int force = Clavier.entrerEntier(question.toString());
					this.controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide ").append(nomVisiteur).append("\n");
		question.append("Quelle est votre force?");
		int force = Clavier.entrerEntier(question.toString());
		int forceMin = 1;
		int forceMax = 0;
		do {
			StringBuilder question2 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produisez?\n");
			forceMin = Clavier.entrerEntier(question.toString());
			question2.append("Quelle est la force de potion la plus forte que vous produisez?\n");
			forceMax = Clavier.entrerEntier(question.toString()); 
			if(forceMin > forceMax) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		} while (forceMin > forceMax);
		this.controlEmmenager.ajouterDruide(nomVisiteur, force, forceMin, forceMax);
	}
	
}
