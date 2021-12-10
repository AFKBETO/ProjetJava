package V1;

public abstract class Question {
    private final String text;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    private boolean selectionee;

    /**
     * Constructeur de la classe abstraite Question
     * @param text : texte de la question
     * @param difficulte : difficulté de la question, peut prendre les valeurs 1, 2 ou 3
     * */
    public Question (final String text, final int difficulte) throws IllegalArgumentException {
        if(difficulte<1 || difficulte>3){
            throw new IllegalArgumentException("Niveau de difficulté doit être une valeur entre 1 et 3");
        }
        this.text=text;
        this.difficulte = difficulte;
        this.idQuestion = count++;
        this.selectionee = false;
    }

    /**
     * Cette fonction permet de savoir quelle question est sélectionnée.
     * Elle permet de ne pas choisir cette question plusieurs fois.
     * */
    public boolean estPosee() {
        return this.selectionee;
    }

    /**
     * Cette fonction permet de choisir quelle question est choisi.
     * Cette information permettra de ne pas reposer cette question à un joueur.
     * */
    public void choisi() {
        this.selectionee = true;
    }

    /**
     * Cette fonction permet de récupérer la valeur de la bonne réponse
     * afin de vérifier si l'utilisateur à choisi la bonne réponse.
     * */
    abstract String checkAnswer();

    @Override
    public String toString() {
        return "Question n" + this.idQuestion + " - Difficulté " + this.difficulte + "\nEnoncé : " + this.text;
    }
}
