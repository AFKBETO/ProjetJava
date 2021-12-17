package V1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs {
    private final static int TOTPLAYERS = 20;
    public final static int NBRPLAYERS = 4;
    private final List<Joueur> participants = new ArrayList<>(TOTPLAYERS);
    private final List<Joueur> joueurs = new ArrayList<>(NBRPLAYERS);

    /**
     * Constructeur de la classe Joueurs
     * @param names : liste de nom des 20 joueurs
     */
    public Joueurs(final String[] names) {
        Joueur.resetCount();
        if (names.length == TOTPLAYERS) {
            for(String name : names) {
                participants.add(new Joueur(name));
            }
        }
        else {
            throw new IllegalArgumentException("Il faut ajouter exactement 20 joueurs!!");
        }
    }

    /**
     * Constructeur par défaut de la classe Joueurs
     */
    public Joueurs() {
        Joueur.resetCount();
        for(int i = 0; i < Joueurs.TOTPLAYERS; i++)
        {
            participants.add(new Joueur());
        }
    }

    /**
     * Cette méthode de la classe Joueurs permet de récupérer la liste des joueurs dans le jeu
     */
    public List<Joueur> getJoueurs(){
        return joueurs;
    }

    /**
     * Cette méthode de la classe Joueurs permet de choisir 4 joueurs aléatoires
     * Elle permet également de récupérer cette liste
     */
    public void selectJoueurs() {
        for (int i = 0; i < Joueurs.NBRPLAYERS; i++){
            int Rdcurr = new Random().nextInt(participants.size());
            joueurs.add(participants.get(Rdcurr));
            participants.remove(Rdcurr);
        }
    }

    /**
     * Cette méthode de la classe Joueurs permet de vider la liste des joueurs
     * Dans le cas du grand jeu où les sont parties successives, cette méthode est utilisé à la fin de chaque partie
     */
    public void resJ4() {
        joueurs.clear();
    }

    /**
     * Cette méthode de la classe Joueurs permet de créer une liste de participants
     * Dans la partie finale du grand jeu, on crée une liste avec les 3 gagnants
     * @param joueurs
     */
    public void newJ4(final List<Joueur> joueurs){
        resJ4();
        this.joueurs.addAll(joueurs);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        int i = joueurs.size();
        if (i > 0){
            for (Joueur joueur : joueurs) {
                StringBuilder tmp = i == 1 ? res.append(i).append("er  - ") : res.append(i).append("ème - ");
                res.append(joueur).append("\n");
                i--;
            }
        }
        else{
            for (Joueur joueur: participants) {
                res.append(joueur).append("\n");
            }
        }
        return res.toString();
    }
}