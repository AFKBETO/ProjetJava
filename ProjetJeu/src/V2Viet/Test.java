package V1;

import java.util.ArrayList;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Themes t = new Themes();
        t.choixUnTheme("Histoire");
        t.choixCinqThemes("Sciences","Sport","Littérature","Mathématiques","Langues");
        System.out.println(t);

        Joueurs j = new Joueurs(); //création 20joueurs
        ArrayList<Joueur> j4 = j.selectJoueurs();//sélection 4 joueurs
        Phase1 t1 = new Phase1(); // début phase 1
        t1.selectionJoueur(j4); // ajout 4 joueurs à la phase 1 (changement de leur etat)
        System.out.println(j);

        Phase2 t2 = new Phase2(); // début phase 2
        t2.selectionJoueur(j4); // classement score, dernier -> perdant et les autres gagnants
        System.out.println(j);
        Phase3 t3 = new Phase3(); // début phase 2
        t3.selectionJoueur(j4); // classement score, avant dernier -> perdant et les autres super-gagnants
        System.out.println(j);

        Question q1 = new QCM("ABC",1,"A","B","C",0);
        Question q2 = new RC("DEF",2,"SSS");
        Question q3 = new VF("GHI",3,true);

        Questions questions = new Questions(q1);
        questions.addQuestion(q2);
        questions.addQuestion(q3);

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }
}
