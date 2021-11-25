package V1;

import java.util.List;
import java.util.ArrayList;

public enum ListeThemes {
	Science,
	Histoire,
	Litterature,
	Sport,
	Musique,
	Art,
	Philosophie,
	Geographie,
	Biologie,
	Generale;

	public ListeThemes ChoixUnTheme(String theme){
		return ListeThemes.valueOf(theme);
	}

	public List<ListeThemes> ChoixCinqThemes(String[] themes){
		List<ListeThemes> listethemes = new ArrayList<ListeThemes>();
		for (String theme : themes){
			listethemes.add(ChoixUnTheme(theme));
		}
		return listethemes;
	}

	public List<ListeThemes> ChoixCinqThemes(String theme1,String theme2,String theme3,String theme4,String theme5){
		String[] themes= {theme1,theme2,theme3,theme4,theme5};
		return ChoixCinqThemes(themes);
	}
}
