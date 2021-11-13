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
        this.difficulte=difficulte;
        this.idQuestion=count++;
    }
    
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder("Question no : " + this.idQuestion);
    	s.append("\n"+ this.theme.toString());
    	return s.toString();
    }
}
