package V1;

import java.io.*;
import java.util.List;
import java.util.Objects;

public interface Phase {
    /**
     * Cette méthode d'interface Phase permet de mettre à jour l'état des joueurs
     * @param currJoueur les joueurs en jeu dans cette phase
     */
    void selectionJoueur(List<Joueur> currJoueur);

    /**
     * Cette méthode d'interface Phase permet de démarrer la phase de jeu actuelle
     * Chaque phase se déroule différemment selon les règles, ensuite fait l'appel à currPhase
     * @param currJoueur les joueurs en jeu dans cette phase
     */
    void deroulerPhaseJeu(List<Joueur> currJoueur);

    /**
     * Cette méthode d'interface Phase permet de lancer la partie question et l'incrémentation score/timer
     * @param currTheme : le theme selectionné pour la partie question
     * @param currJoueur : liste des joueurs dans cette phase
     * @param i : indice de joueur
     */
    void currPhase(String currTheme, List<Joueur> currJoueur, int i); //partie question et incrementation score/timer
    List<String> currThemes(List<String> tmp, List<Joueur> j2); //donne les thèmes nécessaire à la phase

    /**
     * Cette méthode de l'interface phase permet de récupérer toutes les questions sur un sujet
     * à partir d'un nom de thème.
     * Les questions sont créées et stockées dans des fichiers classsés par nom de thème et difficultés.
     * @param question : cette objet Question va récupérer l'ensemble des questions lues du fichier.
     * @param name : nom du thème, peut prendre les valeur nom_theme1.txt, nom_theme2.txt, nom_theme3.txt (1, 2 et 3 correspondant au niveau de difficulté des questions).
     * */
    default void createQuestions(Questions question, String name) 
    {
        try
        {
            String filename = "Resources/" + name;
            BufferedReader file = new BufferedReader(new FileReader(filename));
            String str;
            String[] newStr;
            while((str = file.readLine()) != null)
            {
                    newStr = str.split("\\|");
                    if (Objects.equals(newStr[0], "QCM"))
                    {
                        question.addQuestion(new QCM(Integer.parseInt(newStr[1]), newStr[2], newStr[3], newStr[4],
                                newStr[5], Integer.parseInt(newStr[6])));
                    }
                    else if (Objects.equals(newStr[0], "RC"))
                    {
                        question.addQuestion(new RC(Integer.parseInt(newStr[1]), newStr[2], newStr[3]));
                    }
                    else if (Objects.equals(newStr[0], "VF")){
                        question.addQuestion(new VF(Integer.parseInt(newStr[1]), newStr[2],
                                Boolean.parseBoolean(newStr[3])));
                    }
            }
            file.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

