package V2Viet;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Themes {
    private ArrayList<ListeThemes> themes = new ArrayList<ListeThemes>();
    private static int indicateur;

    public Themes(){
    	for (ListeThemes theme:ListeThemes.values()) {
    		this.themes.add(theme);
    	};
    }

    // choix d'un th�me par l'utilisateur
    public ListeThemes choixUnTheme(String theme){
        int id = Arrays.asList(themes).indexOf(ListeThemes.valueOf(theme)); // assignation de l'id
        if (id == indicateur) {
        	System.out.println("Th�me d�j� choisie, choissisez une autre.");
        	return null;
        }
        indicateur = id;
        return themes.get(id);
        //System.out.println(id);
    }

    // choix de 5 thèmes par l'utilisateur
    public ListeThemes[] choixCinqThemes(String[] themes){
        ListeThemes[] results = new ListeThemes[5];
    	return results;
    }

    @Override
    public String toString(){
        String res= "Th�mes : ";
        Collections.sort(themes);  // Sort choix

        for (ListeThemes i : themes) {
            //res=res+"id : "+ Array.asList(themes).indexOf(i).toString()+" nom : "+ i+ ", ";
        }
        return res;
    }

}
