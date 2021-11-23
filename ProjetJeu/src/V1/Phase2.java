package V1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Phase2 implements Phase {
    public void selectionJoueur(List<Joueur> j3) {
        for (Joueur joueur : j3) {
            joueur.majScore(new Random().nextInt(20));
        } //donne un score aléa pour faire des tests, à supprimer quand le système de pts est en place
        j3.sort(Comparator.comparingInt(Joueur::getScore));
        j3.get(0).updateEtat("perdant");
        for (int i = 1; i < j3.size(); i++) {
            j3.get(i).updateEtat("gagnant");
        }
    }

    public void deroulerPhaseJeu() {
    	
    }
}
