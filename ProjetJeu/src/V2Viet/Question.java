package V2Viet;

import java.util.ArrayList;

public abstract class Question {
    private String text;
    private Themes theme;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    
    public Question(String text, Themes theme, int difficulte){
        this.text=text;
        this.theme=theme;
        this.difficulte = difficulte;
        this.idQuestion=count++;
    }
    
    public abstract void saisieQuestion();
    
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder("Question no : " + this.idQuestion);
    	s.append("\n"+ this.theme.toString());
    	s.append("\nDifficult� : "+ this.difficulte);
    	s.append("\nEnonc� : "+ this.text);
    	return s.toString();
    }
}
