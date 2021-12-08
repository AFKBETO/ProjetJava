package V1;

import java.util.*;

public class Phase1 implements Phase {
    public void selectionJoueur(final List<Joueur> j4){
        for (final Joueur joueur : j4) { //changement de l'état des 4 joueurs sélectionnés
            joueur.updateEtat("sélectionné·e");
            System.out.println("Player" + joueur.getNum() + " a été sélectionné !");
        }
    }

    public void deroulerPhaseJeu(final List<Joueur> j4){
        System.out.println("\n-----------------------Démarrage de la Phase 1-----------------------\n");
        List<String> tmp = new ArrayList<>();
        tmp = currThemes(tmp, j4); //creation liste qui contient liste traité phase 1
        currPhase(tmp.get(0), j4, 0); //on lance la 1ere phase avec le premier theme
    }

    public void currPhase(final String aleaTheme, final List<Joueur> j4, int i){
        Questions questionPlayer = new Questions(); //création liste de questions
        createQuestions(questionPlayer, aleaTheme + "1.txt"); //ajout des questions selon thème/difficulté choisis
        System.out.println("Le thème choisit aléatoirement est " + aleaTheme);
        System.out.println("A tour de rôle vous devrez répondre à une question de niveau facile");

        for (final Joueur joueur : j4) { //on itère sur les 4 joueurs
            Question currQuest = questionPlayer.getUneQuestion(); //choisit une question alea pour un joueur
            System.out.println("\nPlayer" + joueur.getNum() + " c'est votre tour" + "\n" + currQuest);
            long startTime = System.currentTimeMillis(); //début timer
            Scanner sc = new Scanner(System.in); //demande de réponse du joueur sur le terminal
            boolean check = false; //booléan pour savoir si le joueur a bien répondu
            if (sc.nextLine().equals(currQuest.checkAnswer())) //vérifie si le joueur a bien répondu
            {
                joueur.addScore(2); //incrémentation du score
                check = true; //permet d'afficher un message cohérent selon bonne ou mauvaise réponse du joueur
            }
            joueur.updateTime((int) (System.currentTimeMillis () - startTime)); //temps de réponse
            System.out.print("La bonne réponse était " + currQuest.checkAnswer()); //affichage bonne réponse
            if (check) { //grace à ce boolean, adaptation du message selon bonne ou mauvaise réponse
                System.out.println(". Bravo !"); //bonne réponse du joueur
            } else {
                System.out.println(". Dommage !"); //mauvaise réponse du joueur
            }
        }
        j4.sort(Comparator.comparingInt(Joueur::getScore).thenComparing(Comparator.comparingInt(Joueur::getTime).reversed()));
        //classement des joueurs selon leur score croissant puis leur temps décroissant si score ex aequo
    }

    public List<String> currThemes(final List<String> tmp, final List<Joueur> j2)
    {
        int currRand = new Random().nextInt(10); //selection aleatoire d'un ID de theme
        String aleaTheme = String.valueOf(Themes.values()[currRand]); //nom theme associé à l'ID donné par currRand
        Themes.choixUnTheme(aleaTheme); //enregistrement de ce theme pour ne pas qu'il revienne en phase 2 au premier tour
        tmp.add(aleaTheme); //enregistrement de ce theme dans une liste courante pour ne pas qu'il revienne en phase 1
        return tmp;
    }
}
