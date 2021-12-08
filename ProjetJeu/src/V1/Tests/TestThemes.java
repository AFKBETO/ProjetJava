package V1.Tests;

import V1.Themes;

import java.util.List;

public class TestThemes {
    public static void main(String[] args) {
        Themes[] themes = Themes.values();
        System.out.println("Print from themes");
        for(Themes theme:themes){
            System.out.println(theme);
            Themes.choixUnTheme(theme.toString());
        }
        System.out.println("Print from ids");
        for (String id:Themes.checkID()) {
            System.out.println(id);
        }
        System.out.println("Size before reset : " + Themes.checkID().size());
        Themes.resID();
        System.out.println("Size after reset : " + Themes.checkID().size());
    }
}
