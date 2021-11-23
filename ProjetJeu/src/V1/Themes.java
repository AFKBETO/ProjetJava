package V1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Themes {
    private final List<Integer> ids = new ArrayList<>();

    private final String[] choix = {"Sciences", "Littérature", "Sport", "Histoire", "Mathématiques", "Langues",
            "Culture Générale"};
    public Themes(){}

    // choix d'un thème par l'utilisateur
    public void choixUnTheme(String theme){
        this.ids.add(Arrays.asList(choix).indexOf(theme)); // assignation de l'id du theme correspondant au thème saisit
        //System.out.println(id);
    }

    // choix de 5 thèmes par l'utilisateur
    public void choixCinqThemes(String theme1, String theme2, String theme3, String theme4, String theme5){
        this.choixUnTheme(theme1);
        this.choixUnTheme(theme2);
        this.choixUnTheme(theme3);
        this.choixUnTheme(theme4);
        this.choixUnTheme(theme5);
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder("Thèmes :\n");
        Collections.sort(ids);  // Sort choix
        for (int i : ids) {
            res.append("ID:").append(i + 1).append(" - ").append(choix[i]).append("\n");
        }
        return res.toString();
    }

}
