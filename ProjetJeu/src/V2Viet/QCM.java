package V2Viet;

import java.util.ArrayList;

public class QCM extends Question {
    private final String[] reps = new String[3];
    private final int bonne_rep;
    public QCM(String text, Themes theme, int difficulte, String r0, String r1, String r2, int bonne_rep){
        super(text,theme,difficulte);
        this.reps[0] = r0;
        this.reps[1] = r1;
        this.reps[2] = r2;
		this.bonne_rep = bonne_rep;
    }
    
    @Override
    public String toString(){
    	StringBuilder s = new StringBuilder(super.toString());
    	int i = 0;
    	for(String rep : this.reps) {
    		s.append("\nR�ponse "+ i + " : "+ rep);
    	}
    	
    	return s.toString();
    }

	@Override
	public void saisieQuestion() {
		// TODO Auto-generated method stub
		
	}
}
