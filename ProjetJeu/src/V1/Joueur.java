package V1;

public class Joueur{
    private final int id;
    private final String nom;
    private String etat;
    private int score;
    private int time;

    public Joueur(String nom, int i){
        this.nom = nom;
        this.etat = "en attente";
        this.score = 0;
        this.time = 0;
        this.id = 100 + i * 10;
    }

    @Override
    public String toString(){
        int mn = time / 60000;
        int sec = time / 1000 - mn * 60;
        int ms = time - mn * 60000 - sec * 1000;
        StringBuilder twodigitS = new StringBuilder("" + sec); //ajout de digit 0 si necessaire pour la lisibilité
        while (twodigitS.length() < 2) twodigitS.insert(0, "0");
        StringBuilder threedigitMS = new StringBuilder("" + ms); //ajout de digit 0 si necessaire pour la lisibilité
        while (threedigitMS.length() < 3) threedigitMS.insert(0, "0");
        return "ID:" + id + " - Nom : " + nom + " - Score:" + score + " - Temps de réponse : " + mn + "mn" +
                twodigitS + "s" + threedigitMS + "ms" + " - Etat : " + etat;
    }

    public int getNum(){
        return id;
    }

    public void addScore(final int score){
        this.score += score;
    }

    public int getScore(){
        return score;
    }

    public void updateEtat(final String etat){
        this.etat = etat;
    }

    public String getEtat(){
        return etat;
    }

    public void updateTime(final int time){
        this.time += time;
    }

    public int getTime(){
        return time;
    }
}
