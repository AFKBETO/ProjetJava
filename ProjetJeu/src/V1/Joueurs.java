package V1;

import java.util.ArrayList;
import java.util.Random;

public class Joueurs {
    private Joueur[] joueurs = new Joueur[20];
    public Joueurs(){
        for(int i = 0;i<joueurs.length;i++){

        }
        selectJoueurs();
    }

    public void selectJoueurs(){
        int numberOfElements = 4;
        Random rd = new Random(); // creating Random object
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
            System.out.println(arr[i]); // printing each array element
        }
        System.out.println(arr);
    }

    public Joueur selectUnJoueur(){
        Random random = new Random();
        int nb = random.nextInt(20);
        return joueurs[nb];
    }
}
