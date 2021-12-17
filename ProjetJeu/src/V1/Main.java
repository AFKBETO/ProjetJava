package V1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        gameProcess: while (true){
            Joueurs joueurs = new Joueurs(); //création 20 joueurs
            joueurs.selectJoueurs(); //sélection 4 joueurs
            System.out.println("\nPour voir les règles saisissez : R" + "\nPour lançer une partie saisissez : J" +
                    "\nPour lançer le grand jeu saisissez : GJ" + "\nPour quitter le jeu saisissez : Q");
            Scanner sc = new Scanner(System.in);
            String ans = sc.nextLine();
            System.out.println();
            switch (ans.toUpperCase()){
                case "R":
                    Rules();
                    break;

                case "J":
                    System.out.println("\n--------------------------------------------Démarrage de la Partie-----" +
                            "---------------------------------------\n");
                    Joueur winner = Game(joueurs);
                    if (winner != null) {
                        System.out.println("\nClassement actuel des Players :\n" + joueurs);
                        System.out.println("\n✨✨✨ Bravo au ✧Player" + winner.getNum() + "✧ qui remporte la partie ✨✨✨\n");
                    }
                    System.out.println("\n--------------------------------------------Arrêt de la Partie----------" +
                            "--------------------------------------\n");
                    break;

                case "GJ" :
                    List<Joueur> winners = new ArrayList<>();
                    int nbrWinners = 0;
                    boolean check = true;
                    while(nbrWinners < 3 && check) { //on lance 3 games succesives
                        Joueur gjWinner = Game(joueurs); //recuperation du gagnant
                        winners.add(gjWinner); //ajout a la liste des gagnants pour le grand jeu
                        if (gjWinner != null) {
                            System.out.println("\nClassement actuel des Players :\n" + joueurs);
                            System.out.println("\n✨✨✨ Bravo au ✧Player" + gjWinner.getNum() + "✧ qui remporte la partie ✨✨✨\n");
                            System.out.println("\n--------------------------------------------Arrêt de la Partie----------" +
                                    "--------------------------------------\n");
                        }
                        else{ // gjWinner = null donc le joueur a demander a quitter
                            check = false; //comme on quitte on utilise ce boolean pour ne pas proceder a la suite du jeu
                        }
                        nbrWinners++;
                        if (nbrWinners != 3) { //tant qu'on n'a pas nos 3 gagnants
                            joueurs.resJ4(); //on res la val j4 de joueurs car 4 nv joueurs
                            joueurs.selectJoueurs(); //sélection 4nv joueurs
                        }
                        else { // ajout des 3 gagnants à j4 en fct de leur points puis de leur temps si égalité
                            winners.sort(Comparator.comparingInt(Joueur::getScore).thenComparing(Comparator.comparingInt(Joueur::getTime).reversed()));
                            joueurs.newJ4(winners); //on ajoute les gagnants à j4
                        }
                    }
                    if (check) {
                        System.out.println("\n-------------------------Début du Grand Jeu-------------------------\n");
                        System.out.println("Bravo aux gagnants des trois précedentes parties :");
                        Joueur gjWinner = gameSuite(joueurs); //on relance a la phase 2 pour les 3 gagnants
                        if (gjWinner != null) { //si !=null alors on a un(e) super vaincqueur·se
                            gjWinner.updateEtat(Joueur.SUPVAINCQUEUR);
                            System.out.println("\nClassement actuel des Players :\n" + joueurs);
                            System.out.println("\n✨✨✨ Bravo au ✧Player" + gjWinner.getNum() + "✧ qui remporte le Grand Jeu ✨✨✨\n");
                        }
                        System.out.println("\n--------------------------------------------Arrêt du Grand Jeu----------" +
                                "--------------------------------------\n");
                    }
                    else {
                        System.out.println("\n--------------------------------------------Arrêt de la Partie----------" +
                                "--------------------------------------\n");
                    }
                    break;

                case "Q" :
                    System.out.println("Merci d'avoir joué à notre jeu, au plaisir de vous revoir !");
                    break gameProcess;

                default:
                    System.out.println("Merci de sélectionner : R - J - GJ - Q !");
                    break;
            }
        }
    }

    static void Rules(){
        try {
            String filename = "Resources\\0rules.txt"; //regles sont stockés dans le fichier exterieur 0rules
            BufferedReader file = new BufferedReader(new FileReader(filename));
            String str;
            while((str = file.readLine()) != null){
                System.out.println(str); //display des règles sur le terminal
            }
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static Joueur Game(final Joueurs joueurs) { //phase 1 du jeu
        System.out.println("\n-------------------------Début de la Partie-------------------------\n");

        Phase1 t1 = new Phase1(); // début phase 1
        t1.selectionJoueur(joueurs); // ajout 4 joueurs à la phase 1 (changement de leur etat)
        if (select(joueurs) == -1) { //select permet au joueur d'avoir acces à des commandes specifiques
            return null; //sélection de l'option quitter la partie courante par le joueur d'ou arret
        }
        t1.deroulerPhaseJeu(joueurs); //lancement phase 1 du jeu

        return gameSuite(joueurs); //suite du jeu avec les phases 2 et 3
    }

    static Joueur gameSuite(final Joueurs joueurs){ //phase 2 et phase 3 du jeu
        Phase2 t2 = new Phase2(); // début phase 2
        t2.selectionJoueur(joueurs); // classement score, dernier -> perdant et les autres gagnants
        System.out.println("\nClassement actuel des Players :\n" + joueurs);
        if(select(joueurs) == -1){ //select permet au joueur d'avoir acces à des commandes specifiques
            return null; //sélection de l'option quitter la partie courante par le joueur d'ou arret
        }
        t2.deroulerPhaseJeu(joueurs); //lancement phase 2 du jeu

        Phase3 t3 = new Phase3(); // début phase 2
        t3.selectionJoueur(joueurs); // classement score, avant dernier -> perdant et les autres restent gagnants
        System.out.println("\nClassement actuel des Players :\n" + joueurs);
        if(select(joueurs) == -1){ //select permet au joueur d'avoir acces à des commandes specifiques
            return null; //sélection de l'option quitter la partie courante par le joueur d'ou arret
        }
        t3.deroulerPhaseJeu(joueurs); //lancement phase 3 du jeu

        return joueurs.getJoueurs().get(joueurs.getJoueurs().size() - 1); //le dernier joueur de la liste est le gagnant, on le retourne pour le gj
    }

    static int select(final Joueurs currPlayers){
        selectProcess: while (true){
            System.out.println("\nPour voir les règles saisissez : R" + "\nPour voir les scores saissisez : S");
            System.out.println("Pour voir les thèmes saissisez : T" + "\nPour continuer de jouer saisissez : C");
            System.out.println("Pour arrêter la partie en cours saisissez : Q");
            Scanner sc = new Scanner(System.in);
            String ans = sc.nextLine();
            System.out.println();
            switch (ans.toUpperCase()){
                case "R":
                    Rules();
                    break;

                case "S":
                    System.out.println("\nClassement actuel des Players :\n" + currPlayers);
                    break;

                case "T":
                    System.out.println("Thème(s) déjà traité(s) :");
                    for(int i = 0; i < Themes.checkID().size(); i++) {
                        System.out.println(Themes.checkID().get(i)); //theme(s) de la liste retourné par checkID
                    }
                    System.out.println("\nThème(s) pas encore traité(s) :");
                    for(int acc = 0; acc < 10; acc++){
                        Themes nTheme = Themes.values()[acc];
                        if (!Themes.checkID().contains(String.valueOf(nTheme))){
                            System.out.println(nTheme); //theme pas dans la liste retourné par checkID
                        }
                    }
                    break;

                case "C":
                    break selectProcess;

                case "Q":
                    Themes.resID(); //reset liste themes car arret abrupt, ce cas est normalement geré en fin de phase 3
                    System.out.println("Merci d'avoir joué cette partie, en espérant vous voir tenter de nouveau !");
                    return -1;

                default:
                    System.out.println("Merci de sélectionner : R - S - T - C - Q !");
                    break;
            }
        }
        return 0;
    }
}
