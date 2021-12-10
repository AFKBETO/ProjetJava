package V1.Tests;

import V1.Phase;
import V1.Phase1;
import V1.Questions;

public class TestCreateQuestions {
    public static void main(String[] args){
        Phase1 phase = new Phase1();
        Questions questions = new Questions();
        phase.createQuestions(questions,"Archeologie1.txt");
        System.out.println(questions);
        /*
        * Question n0 - Difficulté 1
        * Enoncé : Quelle civilisation est à l'origine de Knossos ?
        * 1 - Les Minoens
        * 2 - Les Mycéniens
        * 3 - Les Thraces
        *
        * QCM - Taper 1, 2 ou 3 pour sélectionner votre réponse :
        * Question n1 - Difficulté 1
        * Enoncé : Banteay Srei, le temple des femmes fait partie du complexe d'Angkor, construit par les ?
        * Réponse : à trouver
        * RC - Ecrivez ce que vous jugez être la réponse :
        *
        * Question n2 - Difficulté 1
        * Enoncé : Le temple d'Edfou est en Iran
        * - true
        * - false
        * VF - Taper true or false pour sélectionner votre réponse :
        * Question n3 - Difficulté 1
        * Enoncé : Une tablette de Nefertiti a été retrouvée en Grèce ?
        * - true
        * - false
        * VF - Taper true or false pour sélectionner votre réponse :
        * */

        phase.createQuestions(questions,"Archeologie5.txt"); // Résultat attendu : FileNotFoundException
    }
}
