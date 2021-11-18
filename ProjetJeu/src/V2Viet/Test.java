package V2Viet;

public class Test {
    public static void main(String[] args){
        Themes t = new Themes();
        t.choixUnTheme("Histoire");
        t.choixCinqThemes("Sciences","Sport","Littérature","Mathématiques","Langues");
        System.out.println(t.toString());

        Joueurs j = new Joueurs();
        j.selectJoueurs();
    }
}
