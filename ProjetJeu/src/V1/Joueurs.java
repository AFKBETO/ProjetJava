package V1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs {
    private final static int TOTPLAYERS = 20;
    private final static int NBRPLAYERS = 4;
    private final List<Joueur> joueurs = new ArrayList<>(TOTPLAYERS);
    private final List<Joueur> j4 = new ArrayList<>(NBRPLAYERS);

    public Joueurs(String[] names) {
        Joueur.resetCount();
        if (names.length == TOTPLAYERS) {
            for(String name : names) {
                joueurs.add(new Joueur(name));
            }
        }
        else {
            throw new IllegalArgumentException("Il faut ajouter exactement 20 joueurs!!");
        }
    }

    public Joueurs() {
        Joueur.resetCount();
        for(int i = 0; i < 20; i++)
        {
            joueurs.add(new Joueur());
        }
    }

    public List<Joueur> getJ4(){
        return j4;
    }

    public List<Joueur> selectJoueurs() {
        for (int i = 0; i < 4; i++){
            int Rdcurr = new Random().nextInt(joueurs.size());
            j4.add(joueurs.get(Rdcurr));
            joueurs.remove(Rdcurr);
        }
        return getJ4();
    }

    public void resJ4() {
            j4.clear();
    } //on clear les 4 joueurs courant à la fin d'une partie, dans le cas du grand jeu où les sont parties successives

    public void newJ4(final List<Joueur> joueurs){
        resJ4();
        j4.addAll(joueurs);
    } //recrée j4 avec 3 joueurs dans le grand jeu (phase 2 avec les 3 gagnants)

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        int i = j4.size();
        for (Joueur joueur : j4) {
            StringBuilder tmp = i == 1 ? res.append(i).append("er  - ") : res.append(i).append("ème - ");
            res.append(joueur).append("\n");
            i--;
        }
        return res.toString();
    }
}