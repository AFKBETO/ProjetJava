package V1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs {
    private final int totPlayers = 20;
    private final int nbrPlayers = 4;
    private final List<Joueur> joueurs = new ArrayList<>(totPlayers);
    private final List<Joueur> j4 = new ArrayList<>(nbrPlayers);

    public Joueurs() {
        for(int i = 0; i < totPlayers; i++)
        {
            joueurs.add(new Joueur("Player" + ((i + 10) * 10)));
        }
    }

    public List<Joueur> selectJoueurs() {
        for (int i = 0; i < 4; i++){
            int Rdcurr = new Random().nextInt(joueurs.size());
            j4.add(joueurs.get(Rdcurr));
            joueurs.remove(Rdcurr);
        }
        return j4;
    }

    public void resJ4() {
            j4.clear();
    }

    public void newJ4(final List<Joueur> joueurs){ //recrée j4 avec 3 joueurs dans le grand jeu (phase 2 avec les 3 gagnants)
        resJ4();
        j4.addAll(joueurs);
    }

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