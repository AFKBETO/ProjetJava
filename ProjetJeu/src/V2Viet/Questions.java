package V2Viet;

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
        return questions.get(nb);
    }

    // renvoie deux questions
    public Question[] getDeuxQuestions(){
        Question[] tab = new Question[2];
        tab[0] = this.getUneQuestion();
        tab[1] = this.getUneQuestion();
        while(tab[0]==tab[1]) {
        	tab[1] = this.getUneQuestion();
        }

        return tab;
    }
}
