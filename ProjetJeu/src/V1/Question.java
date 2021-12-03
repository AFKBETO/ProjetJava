package V1;

public abstract class Question {
    private final String text;
    private Themes theme;
    private final int idQuestion;
    private final int difficulte;
    private static int count = 0;
    private boolean selectionee;

    //Constructeur sans Theme - pour tester sans thème
    public Question (final String text, final int difficulte) throws IllegalArgumentException {
        if(difficulte<1 || difficulte>3){
            throw new IllegalArgumentException("Niveau de difficulté doit être une valeur entre 1 et 3");
        }
        this.text=text;
        this.difficulte = difficulte;
        this.idQuestion = count++;
        this.selectionee = false;
    }
    //Constructeur avec Theme
    public Question(final String text, final Themes theme, final int difficulte){
        this(text,difficulte);
        this.theme=theme;
    }

    public int getID() {
        return this.idQuestion;
    }

    public boolean estPosee() {
        return this.selectionee;
    }

    public void choisi() {
        this.selectionee = true;
    }

    abstract String checkAnswer();

    //méthode toString de base
    @Override
    public String toString() {
        return "Question n" + this.idQuestion + " - Difficulté " + this.difficulte +
                "\nEnoncé : " + this.text;
    }
}
