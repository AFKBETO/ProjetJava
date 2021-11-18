package V2Viet;

public class RC extends Question{
    private String bonne_rep;
    
    public RC(String text, ListeThemes theme, int difficulte, String good_rep){
    	super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    public RC(String text, int difficulte, String good_rep){
    	super(text,difficulte);
        this.bonne_rep=good_rep;
    }

	@Override
	public void saisieQuestion() {
		
	}
}
