package V2Viet;

public class VF extends Question{
    private boolean bonne_rep;
    
    public VF(String text, ListeThemes theme, int difficulte, boolean good_rep){
    	super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    
    public VF(String text, int difficulte, boolean good_rep){
    	super(text,difficulte);
        this.bonne_rep=good_rep;
    }
    
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder(super.toString());
    	s.append("\nVrai/Faux?");    	
    	return s.toString();
    }

	@Override
	public void saisieQuestion() {
		// TODO Auto-generated method stub
		
	}
}
