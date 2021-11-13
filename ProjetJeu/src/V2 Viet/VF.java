package V1;

public class VF extends Question{
    private boolean bonne_rep;
    
    public VF(String text, Themes theme, int difficulte, boolean good_rep){
    	super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
}
