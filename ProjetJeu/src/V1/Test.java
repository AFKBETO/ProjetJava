package V1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        Themes t = new Themes();
        t.choixUnTheme("Histoire");
        t.choixCinqThemes("Sciences","Sport","Littérature","Mathématiques","Langues");
        System.out.println(t);

        Joueurs j = new Joueurs();
        Arrays.stream(j.selectJoueurs()).forEach(System.out::println);
    }
}
