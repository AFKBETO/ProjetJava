package V1;

import java.util.ArrayList;
import java.util.List;

public enum Themes {
	Archeologie,
	Gemmologie,
	Geologie,
	Glaciologie,
	Joaillerie,
	Lithotherapie,
	Mineralogie,
	Sedimentologie,
	Speleologie,
	Volcanologie;

	private static final List<String> themes = new ArrayList<>();

	/**
	 * Cette méthode statique de l'enum Themes permet de récupérer toutes les thèmes déjà choisis
	 * Cette information est utilisée pour éviter choisir le même thème
	 */
	public static List<String> checkID(){
		return Themes.themes;
	}

	/**
	 * Cette méthode statique de l'enum Themes permet de vider la liste des thèmes joués
	 * */
	public static void resID(){
		Themes.themes.clear();
	}

	/**
	 * Cette méthode statique de l'enum Themes permet d'ajouter le theme en paramètre dans la liste
	 * des thèmes joués
	 * @param theme : thème à choisir
	 * */
	public static void choixUnTheme(final String theme){
		Themes.themes.add(theme);
	}
}