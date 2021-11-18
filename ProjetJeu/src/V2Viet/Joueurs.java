package V2Viet;

import java.util.ArrayList;
import java.util.Random;

public class Joueurs {
    private final int totPlayers = 20;
    private final int nbrPlayers = 4;
    private final ArrayList<Joueur> joueurs = new ArrayList<>(totPlayers);
    private final ArrayList<Joueur> j4 = new ArrayList<>(nbrPlayers);

    public Joueurs() {
        for(int i = 0; i < totPlayers; i++)
        {
            joueurs.add(new Joueur("MV" + ((i + 10) * 10), "en attente", 0));
            joueurs.get(i).updateNum(i);
        }
    }

    public ArrayList<Joueur> selectJoueurs() {
        j4.add(joueurs.get(new Random().nextInt(20)));
        int curr = 1;
        label: while (curr < nbrPlayers) {
            int Rdcurr = new Random().nextInt(20);
            for (int j = 0; j < curr; j++) {
                if (joueurs.get(Rdcurr).getNum() == j4.get(j).getNum()){
                    continue label;
                }
            }
            j4.add(joueurs.get(Rdcurr));
            curr++;
        }
        return j4;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Joueur joueur : j4) {
            res.append(joueur).append("\n");
        }
        return res.toString();
    }

    public String seeAllPlayers()
    {
        StringBuilder res = new StringBuilder();
        for (Joueur joueur : joueurs) {
            res.append(joueur).append("\n");
        }
        return res.toString();
    }
}