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

	private List<String> ids = new ArrayList<>();

	public List<String> checkID(){
		return ids;
	}

	public void resID(){
		ids = new ArrayList<>();
	}

	public void choixUnTheme(String theme){
		ids.add(theme); // assignation de l'id du theme correspondant au thème saisit
	}
}