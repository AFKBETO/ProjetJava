package V1;

public class VF extends Question{
    private final boolean bonne_rep;

    public VF(int difficulte, String text, Themes theme, boolean good_rep){
        super(text,theme,difficulte);
        this.bonne_rep=good_rep;
    }
    //Constructeur sans Theme
    public VF(int difficulte, String text, boolean good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    //toString qui ajoute vrai/faux
    @Override
    public String toString() {
        return super.toString() + "\n- true" + "\n- false\n" + "VF - Taper true or false pour sélectionner votre réponse :";
    }

    public String checkAnswer(){
        return String.valueOf(bonne_rep);
    }
}
