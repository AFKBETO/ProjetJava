package V1;

public class VF extends Question{
    private final boolean bonne_rep;

    /**
     * Constructeur des questions de type VF
     * Cette classe est une classe fille de la classe Question.java
     * @param difficulte : difficulté de la question, peut prendre les valeurs 1, 2 ou 3
     * @param text : texte de la question
     * @param good_rep : variable permettant d'identifier la bonne réponse à la question, peut prendre les valeurs true ou false
     */
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
