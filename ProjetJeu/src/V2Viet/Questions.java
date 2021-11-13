package V2Viet;

import java.util.ArrayList;
import java.util.Random;

public class Questions {
    private String text;
    private String theme;
    private int numQuestion;
    private ArrayList<String> questions = new ArrayList<String>();
    public Questions(String text){
        this.text=text;
    }

    // Ajout de question
    public void addQuestion(String question){
        questions.add(question);
    }

    public void delQuestion(int i){
        questions.remove(i);
    }

    //renvoie une question
    public String getUneQuestion(){
        Random random = new Random();
        int nb;
        nb = random.nextInt(numQuestion);
        return questions.get(nb);
    }

    // renvoie deux questions
    public ArrayList<String> getDeuxQuestions(){
        ArrayList<String> tab = new ArrayList<String>();
        Random random = new Random();
        int nb;
        nb = random.nextInt(numQuestion);
        tab.add(questions.get(nb));

        return tab;
    }
}
