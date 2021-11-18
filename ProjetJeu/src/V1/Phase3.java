package V1;

import java.util.ArrayList;
import java.util.Comparator;

public class Phase3 implements Phase {
    public void selectionJoueur(ArrayList<Joueur> j2) {
        //j2.sort(Comparator.comparingInt(Joueur::getScore));
        j2.get(1).updateEtat("perdant");
        for (int i = 2; i < j2.size(); i++) {
            j2.get(i).updateEtat("super-gagnant");
        }
    }

    public void deroulerPhaseJeu() {
    	
    }
}
