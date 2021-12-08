package V1.Tests;

import V1.Joueur;
import V1.Joueurs;

import java.util.ArrayList;
import java.util.List;

public class TestJoueurs {
    public static void main(String[] args) {
        Joueurs joueurs = new Joueurs();
        List<Joueur> j4 = new ArrayList<Joueur>();
        for(Joueur joueur:joueurs.selectJoueurs()){
            j4.add(joueur);
        }
        System.out.println(joueurs);
        for (Joueur j:joueurs.getJ4()) {
            System.out.println(j);
        }
        joueurs.resJ4();
        System.out.println(joueurs.getJ4().size());
        joueurs.newJ4(j4);
        for (Joueur j:joueurs.getJ4()) {
            System.out.println(j);
        }
    }
}
