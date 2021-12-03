package V1;

import java.io.*;
import java.util.List;
import java.util.Objects;

public interface Phase {
    Themes t = Themes.Archeologie;

    void selectionJoueur(List<Joueur> currJoueur); //update etat Players,
    void deroulerPhaseJeu(List<Joueur> currJoueur); //déroulement de la phase selon les règles, appel à currPhase
    void currPhase(String currTheme, List<Joueur> currJoueur, int i); //partie question et incrementation score/timer
    List<String> currThemes(List<String> tmp, List<Joueur> j2); //donne les thèmes nécessaire à la phase

    default void createQuestions(Questions question, String name) //crée les questions et les ajoute a l'obj question
    {                                                             //selection selon le thème et la difficulté dans name
        try
        {
            String filename = "Resources\\" + name;
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

