package V1;

import V2Viet.Question;

import java.util.ArrayList;
import java.util.Random;

public class Questions {
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Questions(Question question){
        this.addQuestion(question);
    }

    // Ajout de question
    public void addQuestion(Question question){
        questions.add(question);
    }

    public void delQuestion(int i){
        questions.remove(i);
    }

    //renvoie une question
    public Question getUneQuestion(){
        Random random = new Random();
        int nb;
        nb = random.nextInt(questions.size());
        while(questions.get(nb).estPosee()) {
            nb = random.nextInt(questions.size());
        }
        questions.get(nb).choisi();
        return questions.get(nb);
    }

    // renvoie deux questions
    public Question[] getDeuxQuestions(){
        V2Viet.Question[] tab = new Question[2];
        tab[0] = this.getUneQuestion();
        tab[1] = this.getUneQuestion();
        return tab;
    }
}
