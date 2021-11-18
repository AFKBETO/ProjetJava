package V1;

import V2Viet.ListeThemes;

public class VF extends Question{
    private boolean bonne_rep;

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
        StringBuilder s = new StringBuilder();
        s.append("\nVrai/Faux?");
        return super.toString() + "\nVrai/Faux ?\n";
    }

    @Override
    public void saisieQuestion() {
        // TODO Auto-generated method stub

    }
}
