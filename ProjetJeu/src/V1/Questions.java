package V1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private final List<Question> questions = new ArrayList<>();

    /**
     * Cette fonction permet d'ajouter des Question à notre objet Questions
     * */
    public void addQuestion(final Question question){
        questions.add(question);
    }

    /**
     * Cette fonction permet de renvoyer une Question contenue dans notre objet Questions.
     * La sélection de la question se fait de manière aléatoire.
     * Avant de renvoyer la question, on vérifie que la question n'a pas été précédemment posée à un joueur.
     * */
    public Question getUneQuestion(){
        int nb = new Random().nextInt(questions.size());
        while(questions.get(nb).estPosee()) {
            nb = new Random().nextInt(questions.size());
        }
        questions.get(nb).choisi();
        return questions.get(nb);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Question question : questions) {
            s.append(question.toString()).append("\n");
        }
        return s.toString();
    }
}
