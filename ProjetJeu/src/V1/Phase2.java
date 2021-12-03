package V1;

import java.util.*;

public class Phase2 implements Phase {
    public void selectionJoueur(final List<Joueur> j3) {
        if (j3.size() > 3) { //cas avec 4 joueurs -> le dernier joueur est perdant, pas qd le grand jeu d'ou size>3 (3j)
            j3.get(0).updateEtat("Perdant·e phase 1"); //le premier dans la liste est le perdant de la phase précedente
            System.out.println("\nPlayer" + j3.get(0).getNum() + " tombe à la Phase 1 !");
        }
        for (int i = j3.size() - 3; i < j3.size(); i++) { //les autres sont victorieux
            j3.get(i).updateEtat("Vaincqueur·e");
            System.out.println("Player" + j3.get(i).getNum() + " accède à la Phase 2 !");
        }
    }

    public void deroulerPhaseJeu(final List<Joueur> j3){
        System.out.println("\n-----------------------Démarrage de la Phase 2-----------------------\n");
        List<String> tmp = new ArrayList<>();
        tmp = currThemes(tmp, j3);
        int i = j3.size() - 1;
        while (tmp.size() != 0) { //bouclage tant tant que les 6 thèmes n'ont pas été traités
            System.out.println("\nPlayer" + j3.get(i).getNum() + " choississez le chiffre associé à un thème parmi :");
            for (int acc = 0; acc < tmp.size(); acc++) {
                System.out.println("(" + acc + ") " + tmp.get(acc)); // liste des thèmes encore disponible
            }
            Scanner sc = new Scanner(System.in);
            int ans;
            try{
                ans = Integer.parseInt(sc.nextLine()); //récupération de ce qu'a écrit l'utilisateur
            }catch(Exception e ){ //verification que cela soit bien un int
                System.out.println("Merci de choisir un chiffre !");
                continue;
            }
            if ((ans < 0 || ans > tmp.size())) { //on vérifie que l'utilisateur choississe bien un thème dispo
                System.out.println("Merci de choisir un chiffre valide !");
                continue;
            }
            currPhase(tmp.get(ans), j3, i); //on passe aux questions si le thème est bien parmi ceux de la liste
            tmp.remove(ans); //on remove le thème pour qu'il ne soit plus appelable durant la phase 2
            i--; //update pour avoir ID du prochain joueur
            if (j3.size() == 4 && i == 0) {
                i = j3.size() - 1; //on reboucle quand le i < 0 car ID est associé au joueur des positions 1 à 3 dans la liste
            }
            else if(j3.size() == 3 && i == -1)
            {
                i = j3.size() - 1;
            }
        }
        j3.sort(Comparator.comparing(Joueur::getEtat).thenComparingInt(Joueur::getScore).thenComparing(Comparator.comparingInt(Joueur::getTime).reversed()));
        // triple comparaison successive (se déclenche que si ex aequo avant) pour déterminer le classement courant
        // dabord si le joueur est gagnant ou perdant puis selon les scores et enfin selon le timer
    }

    public void currPhase(final String aleaTheme, final List<Joueur> j3, final int i) {
        Questions questionPlayer = new Questions(); //création liste de questions
        createQuestions(questionPlayer, aleaTheme + "2.txt"); //ajout des questions selon thème/difficulté choisis
        System.out.println("\nLe thème choisit par Player" + j3.get(i).getNum() + " est " + aleaTheme);
        System.out.println("Vous devrez répondre à deux questions de niveau moyen sur ce thème\n");

        for(int acc = 1; acc < 3; acc++) {
            Question currQuest = questionPlayer.getUneQuestion(); //choisit une question alea pour un joueur
            System.out.println("\nLa "+(acc == 1 ? "première question est la " : "seconde question est la ")+currQuest);
            long startTime = System.currentTimeMillis(); //début timer
            Scanner sc = new Scanner(System.in); //demande de réponse du joueur sur le terminal
            boolean check = false; //booléan pour savoir si le joueur a bien répondu
            if (sc.nextLine().equals(currQuest.checkAnswer())) //vérifie si le joueur a bien répondu
            {
                j3.get(i).majScore(3); //incrémentation du score
                check = true; //permet d'afficher un message cohérent selon bonne ou mauvaise réponse du joueur
            }
            j3.get(i).updateTime((int) (System.currentTimeMillis() - startTime)); //temps de réponse
            System.out.print("La bonne réponse était " + currQuest.checkAnswer()); //affichage bonne réponse
            if (check) { //grace à ce boolean, adaptation du message selon bonne ou mauvaise réponse
                System.out.println(". Bravo !"); //bonne réponse du joueur
            } else {
                System.out.println(". Dommage !"); //mauvaise réponse du joueur
            }
        }
    }

    public List<String> currThemes(final List<String> tmp, final List<Joueur> j3){
        while(tmp.size() < 6) //selection de 6 thèmes aléatoirement
        {
            int currRand = new Random().nextInt(10); //selection ID theme aleatoire
            String currTheme = String.valueOf(Themes.values()[currRand]); //theme associé à l'ID
            if(!Themes.checkID().contains(currTheme)) //verification que le thème est pas déjà été choisit en phase2
            {
                tmp.add(currTheme); //on ajoute à la liste des themes de la phase2 pour pas qu'il soit reselectionnable
                Themes.choixUnTheme(currTheme); //on ajoute a la liste globale pour pas les reprendre en phase 3
            }
        }
        System.out.println("Player" + j3.get(j3.size() - 1).getNum() +" a fini premier·ère a la Phase 1, iel choisit donc dabord !");
        System.out.println("Puis Player" + j3.get(j3.size() - 2).getNum() + " va choisir en second et enfin Player" +
                j3.get(j3.size() - 3).getNum() + " en troisième !\nCe cycle va se répeter deux fois !");
        return tmp;
    }
}
