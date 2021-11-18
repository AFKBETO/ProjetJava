package V1;

public class RC extends Question{
    private final String bonne_rep;

    public RC(String text, ListeThemes theme, int difficulte, String good_rep){
        super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    //constructeur sans Theme
    public RC(String text, int difficulte, String good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    //toString qui ajoute R�ponse :
    @Override
    public String toString() {
        return super.toString() + "\nRéponse :\n";
    }

    @Override
    public void saisieQuestion() {

    }
}
