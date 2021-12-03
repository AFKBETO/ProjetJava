package V1;

public class Joueur{
    private int ID = 100;
    private final String nom;
    private String etat;
    private int score;
    private int time;

    public Joueur(String nom, String etat, int score, int time){
        this.nom = nom;
        this.etat = etat;
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString(){
        int mn = time/60000;
        int sec = time/1000 - mn * 60;
        int ms = time - mn * 60000 - sec * 1000;
        StringBuilder twodigitS = new StringBuilder("" + sec); //ajout de digit 0 si necessaire pour la lisibilité
        while (twodigitS.length() < 2) twodigitS.insert(0, "0");
        StringBuilder threedigitMS = new StringBuilder("" + ms); //ajout de digit 0 si necessaire pour la lisibilité
        while (threedigitMS.length() < 3) threedigitMS.insert(0, "0");
        return "ID:" + ID + " - Nom : " + nom + " - Score:" + score + " - Temps de réponse : " + mn + "mn" +
                twodigitS + "s" + threedigitMS + "ms" + " - Etat : " + etat;
    }

    public void updateNum(int ID){
        this.ID += 10 * ID;
    }

    public int getNum(){
        return ID;
    }

    public void majScore(int score){
        this.score += score;
    }

    public int getScore(){
        return score;
    }

    public void updateEtat(String etat){
        this.etat = etat;
    }

    public String getEtat(){
        return etat;
    }

    public void updateTime(int time){
        this.time += time;
    }

    public int getTime(){
        return time;
    }
}
