package V1;

import java.util.Random;

public class Joueurs {
    private final int nbrPlayers = 4;
    private final Joueur[] joueurs = new Joueur[20];

    public Joueurs(){
        for(int i = 0; i < joueurs.length; i++){
            joueurs[i] = new Joueur("3MV" + ((i + 10) * 10), "en attente", 0);
            joueurs[i].updateNum(i);
        }
    }

    public Joueur[] selectJoueurs(){
        Joueur[] arr = new Joueur[nbrPlayers];
        arr[0] = joueurs[new Random().nextInt(20)];
        int curr = 1;
        label: while(curr < nbrPlayers)
        {
            int Rdcurr = new Random().nextInt(20);
            for(int j = 0; j < curr; j++)
            {
                if(joueurs[Rdcurr].getNum() == arr[j].getNum())
                {
                    curr--;
                    continue label;
                }
            }
            arr[curr] = joueurs[Rdcurr];
            curr++;
        }
        return arr;
    }
}
