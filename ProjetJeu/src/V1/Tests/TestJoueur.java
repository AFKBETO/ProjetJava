package V1.Tests;

import V1.Joueur;

public class TestJoueur {
    public static void main(String[] args) {
        Joueur player = new Joueur("Manuel Macron");
        System.out.println("Initialize :\n" + player);
        System.out.println("ID : " + player.getNum());
        player.addScore(10);
        System.out.println("Score : " + player.getScore());
        player.updateEtat(Joueur.SELECTIONE);
        System.out.println("Etat : " + player.getEtat());
        player.updateTime(1000);
        System.out.println("Temps : " + player.getTime());
        System.out.println("Résultat :\n" + player);
        player.updateEtat("Nonsense");
    }
}
