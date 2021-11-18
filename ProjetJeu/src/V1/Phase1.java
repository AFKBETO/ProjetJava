package V1;

import java.util.ArrayList;

public class Phase1 implements Phase {
    public void selectionJoueur(ArrayList<Joueur> j4) {
        for (Joueur joueur : j4) {
            joueur.updateEtat("sélectionné");
        }

    }

    public void deroulerPhaseJeu() {
    	
    }
}
