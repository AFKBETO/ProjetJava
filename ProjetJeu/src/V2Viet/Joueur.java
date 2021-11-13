package V2Viet;

public class Joueur {
    private int numero;
    private String nom;
    private String etat;
    private int score;
    public Joueur(String nom, String etat, int score){
        this.numero=100;
        this.nom=nom;
        this.etat=etat;
        this.score=score;
    }

    @Override
    public String toString(){
        return "Joueur "+numero+" nom : "+nom+" score : "+score+"etat : "+etat;
    }

    public void updateNum(){
        numero+=10;
    }

    public void majScore(int points){
        score+=points;
    }

    public void updateEtat(String etat){
        this.etat=etat;
    }
}
