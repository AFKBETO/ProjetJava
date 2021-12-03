package V1;

public class RC extends Question{
    private final String bonne_rep;

    public RC(final int difficulte, final String text, final Themes theme, final String good_rep){
        super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    //constructeur sans Theme
    public RC(final int difficulte, final String text, final String good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    //toString qui ajoute R�ponse :
    @Override
    public String toString() {
        return super.toString() + "\nRéponse : à trouver\n" + "RC - Ecrivez ce que vous jugez être la réponse :";
    }

    public String checkAnswer(){
        return bonne_rep;
    }
}
