package V1;

public abstract class Question {
    private final String text;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    private boolean selectionee;

    public Question (final String text, final int difficulte) throws IllegalArgumentException {
        if(difficulte<1 || difficulte>3){
            throw new IllegalArgumentException("Niveau de difficulté doit être une valeur entre 1 et 3");
        }
        this.text=text;
        this.difficulte = difficulte;
        this.idQuestion = count++;
        this.selectionee = false;
    }

    public boolean estPosee() {
        return this.selectionee;
    }

    public void choisi() {
        this.selectionee = true;
    }

    abstract String checkAnswer();

    @Override
    public String toString() {
        return "Question n" + this.idQuestion + " - Difficulté " + this.difficulte + "\nEnoncé : " + this.text;
    }
}
