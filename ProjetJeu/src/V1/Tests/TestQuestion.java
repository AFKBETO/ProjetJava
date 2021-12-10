package V1.Tests;

import V1.QCM;
import V1.Question;
import V1.RC;
import V1.VF;

public class TestQuestion {
    public static void main(String[] args){
        RC q1 = new RC(1,"Quelle est la capitale de la France","Paris");
        VF q2 = new VF(2,"La capital de le France est Paris",true);
        QCM q3 = new QCM(1,"Quelle est la capitale de la France ?","Paris","Londre","Prague",1);
        //VF q4 = new VF(5, "La capitale de l'Angleterre est Londres",true); // résultat attendu : throws IllegalArgumentException car 5>3
        //VF q5 = new VF(-1,"La capital de l'Allemagne est Prague",false); // résultat attendu : throws IllegalArgumentException car -1<1

        //Tests sur la classe Question.java
        q1.choisi();
        System.out.println(q1.estPosee()); //résultat attendu : true
        System.out.println((q2.estPosee())); //résultat attendu : false

        //Test sur la classe RC.java
        System.out.println(q1);
        /* résultat attendu :
        * Question n0 - Difficulté 1
        * Enoncé : Quelle est la capitale de la France
        * Réponse : à trouver
        * RC - Ecrivez ce que vous jugez être la réponse : */
        System.out.println(q1.checkAnswer()); // résultat attendu : Paris

        //Tests sur la classe VF.java
        System.out.println(q2);
        /* résultat attendu :
         * Question n1 - Difficulté 2
         * Enoncé : La capital de le France est Paris
         * - true
         * - false
         * VF - Taper true or false pour sélectionner votre réponse : */
        System.out.println(q2.checkAnswer()); // résultat attendu : true

        //Tests sur la classe QCM.java
        System.out.println(q3);
        /* résultat attendu :
         * Question n2 - Difficulté 1
         * Enoncé : Quelle est la capitale de la France ?
         * 1 - Paris
         * 2 - Londre
         * 3 - Prague
         * QCM - Taper 1, 2 ou 3 pour sélectionner votre réponse : */
        System.out.println(q3.checkAnswer()); // résultat attendu : 1
    }
}
