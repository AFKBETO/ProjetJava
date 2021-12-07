package V1;

public class VF extends Question{
    private final boolean bonne_rep;

    public VF(final int difficulte, final String text, final boolean good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    @Override
    public String toString() {
        return super.toString() + "\n- true" + "\n- false\n" + "VF - Taper true or false pour sélectionner votre réponse :";
    }

    public String checkAnswer(){
        return String.valueOf(bonne_rep);
    }
}
