package V1.Tests;

import V1.QCM;
import V1.Questions;
import V1.RC;
import V1.VF;

public class TestQuestions {
    public static void main(String[] args){
        Questions questions = new Questions();
        RC q1 = new RC(1,"Quelle est la capitale de la France","Paris");
        VF q2 = new VF(2,"La capital de le France est Paris",true);
        QCM q3 = new QCM(1,"Quelle est la capitale de la France ?","Paris","Londre","Prague",1);

        questions.addQuestion(q1);
        questions.addQuestion(q2);
        questions.addQuestion(q3);

        System.out.println(questions);
        //résultat attendu : appel au toString de chaque question contenue dans questions
        /*
        * Question n0 - Difficulté 1
        * Enoncé : Quelle est la capitale de la France
        * Réponse : à trouver
        * RC - Ecrivez ce que vous jugez être la réponse :
        * Question n1 - Difficulté 2
        *Enoncé : La capital de le France est Paris
        * - true
        * - false
        * VF - Taper true or false pour sélectionner votre réponse :
        * Question n2 - Difficulté 1
        * Enoncé : Quelle est la capitale de la France ?
        * 1 - Paris
        * 2 - Londre
        * 3 - Prague
        * QCM - Taper 1, 2 ou 3 pour sélectionner votre réponse :*/
    }
}
