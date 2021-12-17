package V1;

import java.util.*;

public class Phase3 implements Phase {
    public void selectionJoueur(final Joueurs joueurs) {
        joueurs.getJoueurs().get(joueurs.getJoueurs().size()-3).updateEtat(Joueur.PERDU_P2); //le second dans la liste est le perdant de la phase, classement du 4ème au 1er
        System.out.println("\nPlayer" + joueurs.getJoueurs().get(joueurs.getJoueurs().size() - 3).getNum() + " tombe à la Phase 2 !");
        for (int i = 3; i < joueurs.getJoueurs().size(); i++) { //les autres sont victorieux
            joueurs.getJoueurs().get(i).updateEtat(Joueur.VAINCQUEUR);
            System.out.println("Player" + joueurs.getJoueurs().get(i).getNum() + " accède à la Phase 3 !");
        }
    }

    public void deroulerPhaseJeu(final Joueurs joueurs) {
        List<String> tmp = new ArrayList<>(); //liste pour stocker les 3 thèmes traités en phase 3
        tmp = currThemes(tmp, joueurs.getJoueurs()); //récupération de 3 thèmes n'ayant pas encore été traité
        while (tmp.size() != 0) { //bouclage tant que les 3 themes n'ont pas été traité
            currPhase(tmp.get(0), joueurs, joueurs.getJoueurs().size() - 1); //on lance les questions sur l'un des trois themes
            tmp.remove(0); //on supprime le thème une fois ce dernier joué
        }
        Themes.resID(); //reset des themes utilisés pour ne pas etre bloqué dans le cas du grand jeu
        joueurs.getJoueurs().sort(Comparator.comparing(Joueur::getEtat).thenComparingInt(Joueur::getScore).thenComparing(Comparator.comparingInt(Joueur::getTime).reversed()));
        joueurs.getJoueurs().get(joueurs.getJoueurs().size() - 2).updateEtat(Joueur.PERDU_P3); //passage du joueur ayant perdu la phase 3 a perdant
    }

    public void currPhase(final String aleaTheme, final Joueurs joueurs, int indice){
        Questions questionPlayer = new Questions(); //création liste de questions
        createQuestions(questionPlayer, aleaTheme + "3.txt"); //ajout des questions selon thème/difficulté choisis
        System.out.println("\nLe thème choisi aléatoirement est " + aleaTheme);
        System.out.println("A tour de rôle vous devrez répondre à une question de niveau difficile");

        for(int acc = 1; acc < 3; acc++) {
            Question currQuest = questionPlayer.getUneQuestion(); //choisit une question alea pour un joueur
            System.out.println("\nPlayer" + joueurs.getJoueurs().get(indice).getNum() + " c'est votre tour");
            System.out.println("La "+(acc == 1 ? "première question est la " : "seconde question est la ")+currQuest);
            long startTime = System.currentTimeMillis(); //début timer
            Scanner sc = new Scanner(System.in); //demande de réponse du joueur sur le terminal
            boolean check = false; //booléan pour savoir si le joueur a bien répondu
            if (sc.nextLine().equals(currQuest.checkAnswer())) //vérifie si le joueur a bien répondu
            {
                joueurs.getJoueurs().get(indice).addScore(5); //incrémentation du score
                check = true; //permet d'afficher un message cohérent selon bonne ou mauvaise réponse du joueur
            }
            joueurs.getJoueurs().get(indice).updateTime((int) (System.currentTimeMillis() - startTime)); //temps de réponse
            System.out.print("La bonne réponse était " + currQuest.checkAnswer()); //affichage bonne réponse
            if (check) { //grace à ce boolean, adaptation du message selon bonne ou mauvaise réponse
                System.out.println(". Bravo !"); //bonne réponse du joueur
            } else {
                System.out.println(". Dommage !"); //mauvaise réponse du joueur
            }
            indice--;
        }
    }

    public List<String> currThemes(final List<String> tmp, final List<Joueur> j2){
        for(int acc = 0; acc < 10; acc++){
            String currTheme = String.valueOf(Themes.values()[acc]); //récupération d'un thème séquentiellement
            if (!Themes.checkID().contains(currTheme)){ //si le thème n'a pas encore été traité
                tmp.add(currTheme); //on l'ajoute à notre liste courante de la phase 3
                Themes.choixUnTheme(currTheme); //a la liste globale des themes
            }
        }
        System.out.println("\n-----------------------Démarrage de la Phase 3-----------------------\n");
        System.out.println("Player" + j2.get(j2.size() - 1).getNum() + " a fini premier·ère a la Phase 2, iel répond en premier·ère !");
        System.out.println("Player" + j2.get(j2.size() - 2).getNum() + " a fini second·e a la Phase 2, iel répond donc en second·e !");
        System.out.println("Ce cycle va se répeter trois fois !");
        return tmp;
    }
}
