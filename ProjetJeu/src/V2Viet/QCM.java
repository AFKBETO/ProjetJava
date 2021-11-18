package V2Viet;

import java.util.ArrayList;

public class QCM extends Question {
    private final String[] reps = new String[3];
    private final int bonne_rep;
    public QCM(String text, ListeThemes theme, int difficulte, String r0, String r1, String r2, int bonne_rep){
        super(text,theme,difficulte);
        this.reps[0] = r0;
        this.reps[1] = r1;
        this.reps[2] = r2;
		this.bonne_rep = bonne_rep;
    }
    //constructeur sans Theme
    public QCM(String text, int difficulte, String r0, String r1, String r2, int bonne_rep){
        super(text,difficulte);
        this.reps[0] = r0;
        this.reps[1] = r1;
        this.reps[2] = r2;
		this.bonne_rep = bonne_rep;
    }
    
    //toString pour ajouter des réponses de QCM
    @Override
    public String toString(){
    	StringBuilder s = new StringBuilder(super.toString());
    	int i = 1;
    	for(String rep : this.reps) {
    		s.append("\nRéponse "+ i + " : "+ rep);
    		i++;
    	}
    	s.append("\n");
    	
    	return s.toString();
    }

	@Override
	public void saisieQuestion() {
		// TODO Auto-generated method stub
		
	}
}
