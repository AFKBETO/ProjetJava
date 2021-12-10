package V1;

public class RC extends Question{
    private final String bonne_rep;

    /**
     * Constructeur des questions de type VF
     * Cette classe est une classe fille de la classe Question.java
     * @param difficulte : difficulté de la question, peut prendre les valeurs 1, 2 ou 3
     * @param text : texte de la question
     * @param good_rep : variable de texte permettant d'identifier la bonne réponse à la question, elle contient la bonne réponse à la question
     */
    public RC(final int difficulte, final String text, final String good_rep){
        super(text,difficulte);
        this.bonne_rep=good_rep;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRéponse : à trouver\n" + "RC - Ecrivez ce que vous jugez être la réponse :";
    }

    public String checkAnswer(){
        return bonne_rep;
    }
}
