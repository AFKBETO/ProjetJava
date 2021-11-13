package V2Viet;

public class QCM extends Question {
    private final String rep1, rep2, rep3;
    private final String bonne_rep;
    public QCM(String text, Themes theme, int difficulte, String r1, String r2, String r3, String bonne_rep){
        super(text,theme,difficulte);
        this.rep1=r1;
        this.rep2=r2;
        this.rep3=r3;
		this.bonne_rep = bonne_rep;

    }
}
