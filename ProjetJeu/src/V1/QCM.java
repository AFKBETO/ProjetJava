package V1;

import java.util.ArrayList;
import java.util.List;

public class QCM extends Question {
    private final List<String> reps = new ArrayList<>();
    private final int bonne_rep;
    public QCM(int difficulte, String text, Themes theme, String r0, String r1, String r2, int bonne_rep){
        super(text,theme,difficulte);
        this.reps.add(r0);
        this.reps.add(r1);
        this.reps.add(r2);
        this.bonne_rep = bonne_rep;
    }
    //constructeur sans Theme
    public QCM(int difficulte, String text, String r0, String r1, String r2, int bonne_rep){
        super(text,difficulte);
        this.reps.add(r0);
        this.reps.add(r1);
        this.reps.add(r2);
        this.bonne_rep = bonne_rep;
    }

    //toString pour ajouter des r�ponses de QCM
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(super.toString() + "\n");
        int acc = 1;
        for(String rep : reps) {
            s.append(acc).append(" - ").append(rep).append("\n");
            acc++;
        }
        s.append("\n").append("QCM - Taper 1, 2 ou 3 pour sélectionner votre réponse :");
        return s.toString();
    }

    public String checkAnswer(){
        return String.valueOf(bonne_rep);
    }
}
