package V1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private final List<Question> questions = new ArrayList<>();

    public Questions(){
    }

    public void addQuestion(Question question){
        questions.add(question);
    } // Ajout de question

    public void delQuestion(int i){
        questions.remove(i);
    } //suppression de question

    public Question getUneQuestion(){ //renvoie une question
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
