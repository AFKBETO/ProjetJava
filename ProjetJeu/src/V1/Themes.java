package V1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Themes {
    private String nom;
    //private int id;
    //private int[] ids;
    private ArrayList<Integer> ids = new ArrayList<Integer>();

    private String[] choix = {"Sciences", "Littérature","Sport","Histoire","Mathématiques","Langues","Culture Générale"};
    public Themes(){}

    // choix d'un thème par l'utilisateur
    public void choixUnTheme(String theme){
        this.ids.add(Arrays.asList(choix).indexOf(theme)); // assignation de l'id du theme correspondant au thème saisit
        //System.out.println(id);
    }

    // choix de 5 thèmes par l'utilisateur
    public void choixCinqThemes(String theme1, String theme2, String theme3, String theme4, String theme5){
        this.ids.add(Arrays.asList(choix).indexOf(theme1));
        this.ids.add(Arrays.asList(choix).indexOf(theme2));
        this.ids.add(Arrays.asList(choix).indexOf(theme3));
        this.ids.add(Arrays.asList(choix).indexOf(theme4));
        this.ids.add(Arrays.asList(choix).indexOf(theme5));
    }

    @Override
    public String toString(){
        String res= "thèmes : ";
        Collections.sort(ids);  // Sort choix

        for (int i : ids) {
            res=res+"id : "+(i+1)+" nom : "+choix[i]+ ", ";
        }
        return res;
    }

}
