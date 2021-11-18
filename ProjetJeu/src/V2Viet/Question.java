package V2Viet;

import java.util.ArrayList;

public abstract class Question {
    private String text;
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
    
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder("Question no : " + this.idQuestion);
    	//s.append("\n"+ this.theme.toString());
    	s.append("\nDifficulté : "+ this.difficulte);
    	s.append("\nEnoncé : "+ this.text);
    	return s.toString();
    }
}
