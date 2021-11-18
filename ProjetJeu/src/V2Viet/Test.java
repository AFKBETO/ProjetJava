package V2Viet;

public class Test {
    public static void main(String[] args){
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
