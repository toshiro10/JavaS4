package quiz;
import questions.AdditionQuestion;
import questions.OtherQuestion;
import questions.SubstractionQuestion;
/**
 * This program administers a ten-question addition, substraction and other quiz to the user.  The numbers
 * for the problem are chosen at random.  The numbers and the answers are one or
 * two digits.  After asking the user the ten questions, the computer grades the
 * quiz, telling the user the correct answer for any problem they got wrong.
 */
public class QuizWithObjects {
    
    private static IntQuestions[] questions;  // The questions for the quiz

    private static int[] userAnswers;   // The user's answers to the ten questions.
    
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the addition quiz!");
        System.out.println();
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }
    
    
    /**
     * Creates the array of objects that holds the quiz questions
     * Substraction, addition is a random choice + a couple of other question
     */
    private static void createQuiz() {
        questions = new IntQuestions [10];
        String otherQuest1 = "What is the answer to the ultimate question " +
                 " of life, the universe, and everything?";
        int answOtherQuest1 =42;
        String otherQuest2 = "How old am I ? >:D";
        int answOtherQuest2 =22;
        
        questions[0] = new OtherQuestion(otherQuest1, answOtherQuest1);
        for ( int i = 1; i < 9; i++ ) {
        	int a = (int)(Math.random()+0.5);
        	if (a == 0) {
        		questions[i] = new SubstractionQuestion();
        	}
        	else {
        		questions[i] = new AdditionQuestion();
        	}
        }
        questions[9] = new OtherQuestion(otherQuest2, answOtherQuest2);
    }
    
    
    /**
     * Asks the user each of the ten quiz questions and gets the user's answers.
     * The answers are stored in an array, which is created in this subroutine.
     */
    private static void administerQuiz() {
        userAnswers = new int[10];
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  %s ",
                                  questionNum, questions[i].getQuestion());
            userAnswers[i] = utils.TextIO.getlnInt();
        }
    }
    
    
    /**
     * Shows all the questions, with their correct answers, and computes a grade
     * for the quiz.  For each question, the user is told whether they got
     * it right.
     */
    private static void gradeQuiz() {
        System.out.println();
        System.out.println("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("   Question %2d:  %s  Correct answer is %d  ",
                questionNum, questions[i].getQuestion(), questions[i].getCorrectAnswer());
            if ( userAnswers[i] == questions[i].getCorrectAnswer() ) {
                System.out.println("You were CORRECT.");
                numberCorrect++;
            }
            else {
                System.out.println("You said " + userAnswers[i] + ", which is INCORRECT.");
            }
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("You got " + numberCorrect + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
    }

} // end class AdditionQuizWithObjects