package V2Viet;

public class RC extends Question{
    private String bonne_rep;
    
    public RC(String text, Themes theme, int difficulte, String good_rep){
    	super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }

	@Override
	public void saisieQuestion() {
		
	}
}
