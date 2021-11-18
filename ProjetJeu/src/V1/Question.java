package V1;

import java.util.ArrayList;

public abstract class Question {
    private final String text;
    private ListeThemes theme;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    private boolean selectionee;

    public Question(String text, ListeThemes theme, int difficulte){
        this.text=text;
        this.theme=theme;
        this.difficulte = difficulte;
        this.idQuestion=count++;
        this.selectionee = false;
    }

    //Constructeur sans Theme - pour tester sans thème
    public Question(String text, int difficulte){
        this.text=text;
        this.difficulte = difficulte;
        this.idQuestion=count++;
        this.selectionee = false;
    }

    public int getID() {
        return this.idQuestion;
    }

    public boolean estPosee() {
        return this.selectionee;
    }

    public void choisi() {
        this.selectionee = true;
    }

    public abstract void saisieQuestion();

    //méthode toString de base
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Question no : " + this.idQuestion);
        //s.append("\n"+ this.theme.toString()); //mis en commentaire pour tester sans thème
        s.append("\nDifficulté : "+ this.difficulte);
        s.append("\nEnoncé : "+ this.text);
        return s.toString();
    }
}
