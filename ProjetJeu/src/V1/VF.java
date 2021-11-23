package V1;

public class VF extends Question{
    private final boolean bonne_rep;

    public VF(String text, ListeThemes theme, int difficulte, boolean good_rep){
        super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    //Constructeur sans Theme
    public VF(String text, int difficulte, boolean good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    //toString qui ajoute vrai/faux
    @Override
    public String toString() {
        return super.toString() + "\nRéponse : Vrai ou Faux\n";
    }

    @Override
    public void saisieQuestion() {
        // TODO Auto-generated method stub
    }
}
