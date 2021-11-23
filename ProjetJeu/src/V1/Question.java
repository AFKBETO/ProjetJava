package V1;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Question {
    private final String text;
    private ListeThemes theme;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    private boolean selectionee;

    //Constructeur sans Theme - pour tester sans thème
    public Question (String text, int difficulte) throws IllegalArgumentException {
        if(difficulte<1 || difficulte>3){
            throw new IllegalArgumentException("Niveau de difficulté doit être une valeur entre 1 et 3");
        }
        this.text=text;
        this.difficulte = difficulte;
        this.idQuestion=count++;
        this.selectionee = false;
    }
    //Constructeur avec Theme
    public Question(String text, ListeThemes theme, int difficulte){
        this(text,difficulte);
        this.theme=theme;
    }
    //Constructeur avec string Theme
    public Question(String text, String theme, int difficulte){

        this(text,ListeThemes.valueOf(theme) ,difficulte);
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
        return "Question no : " + this.idQuestion + "\nDifficulté : " + this.difficulte +
                "\nEnoncé : " + this.text;
    }
}
