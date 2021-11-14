package V1;

public class Joueur{
    private int ID = 100;
    private final String nom;
    private String etat;
    private int score;

    public Joueur(String nom, String etat, int score){
        this.nom = nom;
        this.etat = etat;
        this.score = score;
    }

    @Override
    public String toString(){ return "ID:" + ID + " - Nom:" + nom + " - Score:" + score + " - Etat:" + etat; }

    public void updateNum(int i){
        ID += 10 * i;
    }

    public void majScore(int points){
        score += points;
    }

    public void updateEtat(String etat){
        this.etat = etat;
    }

    public int getNum(){
        return ID;
    }
}
