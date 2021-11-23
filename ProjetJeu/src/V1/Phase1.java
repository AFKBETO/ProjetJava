package V1;

import java.util.ArrayList;
import java.util.List;

public class Phase1 implements Phase {
    public void selectionJoueur(List<Joueur> j4) {
        for (Joueur joueur : j4) {
            joueur.updateEtat("sélectionné");
        }

    }

    public void deroulerPhaseJeu() {
    	
    }
}
