package V2Viet;

import java.util.ArrayList;

public class QCM extends Question {
    private final ArrayList<String> reps = new ArrayList<String>();
    private final int bonne_rep;
    public QCM(String text, ListeThemes theme, int difficulte, String r0, String r1, String r2, int bonne_rep){
        super(text,theme,difficulte);
        this.reps.add(r0);
        this.reps.add(r1);
        this.reps.add(r2);
        this.bonne_rep = bonne_rep;
    }
    //constructeur sans Theme
    public QCM(String text, int difficulte, String r0, String r1, String r2, int bonne_rep){
        super(text,difficulte);
        this.reps.add(r0);
        this.reps.add(r1);
        this.reps.add(r2);
        this.bonne_rep = bonne_rep;
    }

    //toString pour ajouter des r�ponses de QCM
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(super.toString());
        for(String rep : this.reps) {
            s.append("\nRéponse "+ String.valueOf(reps.indexOf(rep)+1) + " : "+ rep);
        }
        s.append("\n");

        return s.toString();
    }

    @Override
    public void saisieQuestion() {
        // TODO Auto-generated method stub

    }
}
