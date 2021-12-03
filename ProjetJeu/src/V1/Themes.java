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
	Sedimantologie,
	Speleologie,
	Volcanologie;

	private static final List<String> ids = new ArrayList<>();

	public static List<String> checkID(){
		return ids;
	}

	public static void resID(){
		ids.clear();
	}

	public static void choixUnTheme(final String theme){
		ids.add(theme); // assignation de l'id du theme correspondant au thème saisit
	}
}