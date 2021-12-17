package V1;

public class Joueur{
    private static int COUNT = 100;
    private final int id;
    private final String nom;
    private String etat;
    private int score;
    private int time;

    public final static String ATTENTE = "en attente";
    public final static String SELECTIONE = "sélectionné·e";
    public final static String PERDU_P1 = "Perdant·e phase 1";
    public final static String PERDU_P2 = "Perdant·e phase 2";
    public final static String PERDU_P3 = "Perdant·e phase 3";
    public final static String VAINCQUEUR = "Vaincqueur·e";
    public final static String SUPVAINCQUEUR = "Super Vaincqueur·e";

    /**
     * Constructeur de la classe Joueur
     * @param nom : nom du joueur
     */
    public Joueur(final String nom){
        this.nom = nom;
        this.etat = Joueur.ATTENTE;
        this.score = 0;
        this.time = 0;
        this.id = Joueur.COUNT;
        Joueur.COUNT += 10;
    }

    /**
     * Constructeur par défaut de la classe joueur
     * Utiliser "Player" + son ID comme nom de joueur
     */
    public Joueur(){
        this("Player" + Joueur.COUNT);
    }

    /**
     * Cette méthode statique de la classe joueur permet de réinitialiser le compteur de joueur
     */
    public static void resetCount(){
        Joueur.COUNT = 100;
    }

    @Override
    public String toString(){
        int mn = time / 60000;
        int sec = time / 1000 - mn * 60;
        int ms = time - mn * 60000 - sec * 1000;

        //ajout de digit 0 si necessaire pour la lisibilité
        StringBuilder twodigitS = new StringBuilder("" + sec);
        while (twodigitS.length() < 2) twodigitS.insert(0, "0");

        //ajout de digit 0 si necessaire pour la lisibilité
        StringBuilder threedigitMS = new StringBuilder("" + ms);
        while (threedigitMS.length() < 3) threedigitMS.insert(0, "0");

        return "ID:" + id + " - Nom : " + nom + " - Score:" + score + " - Temps de réponse : " + mn + "mn" +
                twodigitS + "s" + threedigitMS + "ms" + " - Etat : " + etat;
    }

    /**
     * Cette méthode de la classe joueur permet de récupérer le numéro du joueur
     */
    public int getNum(){
        return this.id;
    }
    /**
     * Cette méthode de la classe joueur permet de ajouter le score du joueur
     * @param score : le montant à ajouter
     */
    public void addScore(final int score){
        this.score += score;
    }

    /**
     * Cette méthode de la classe joueur permet de récupérer le score du joueur
     */
    public int getScore(){
        return score;
    }

    /**
     * Cette méthode de la classe joueur permet de changer l'état du joueur
     * @param etat : l'etat de joueur
     */
    public void updateEtat(final String etat){
        if(etat.equals(Joueur.SELECTIONE) || etat.equals(Joueur.PERDU_P1) || etat.equals(Joueur.PERDU_P2)
                || etat.equals(Joueur.PERDU_P3) || etat.equals(Joueur.VAINCQUEUR) || etat.equals(Joueur.SUPVAINCQUEUR)){
            this.etat = etat;
        }
        else {
            throw new IllegalArgumentException("Mauvais état");
        }
    }

    /**
     * Cette méthode de la classe joueur permet de récupérer l'état du joueur
     */
    public String getEtat(){
        return this.etat;
    }

    /**
     * Cette méthode de la classe joueur permet de ajouter le temps de réponse du joueur
     * @param time : temps à ajouter
     */
    public void updateTime(final int time){
        this.time += time;
    }

    /**
     * Cette méthode de la classe joueur permet de récupérer le temps de réponse du joueur
     */
    public int getTime() {
        return this.time;
    }
}
