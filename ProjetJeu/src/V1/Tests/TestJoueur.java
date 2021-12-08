package V1.Tests;

import V1.Joueur;

public class TestJoueur {
    public static void main(String[] args) {
        Joueur player = new Joueur("Manuel Macron",1);
        System.out.println("Initialize :\n" + player);
        System.out.println("ID : " + player.getNum());
        player.addScore(10);
        System.out.println("Score : " + player.getScore());
        player.updateEtat("sélectionné·e");
        System.out.println("Etat : " + player.getEtat());
        player.updateTime(1000);
        System.out.println("Temps : " + player.getTime());
        System.out.println("Résultat :\n" + player);
    }
}
