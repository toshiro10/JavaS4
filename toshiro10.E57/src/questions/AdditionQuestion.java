package questions;

/**
 * AdditionQuestion is a class that implements the interface IntQuestions
 * It creates an addition question of two random numbers. The first number is between 0 to 51
 * and the second one between 0 to 50.
 * @author Antony, Abdelkader
 *
 */
public class AdditionQuestion implements quiz.IntQuestions {

    private int a, b;  // The numbers in the problem.
    
    public AdditionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }
    /**
     * Returns the question asked
     * @return String : question
     */
    public String getQuestion() {
        return "What is " + a + " + " + b + " ?";
    }
    
    /**Returns the answer of the question
     * @return int : result of the question
     */
    public int getCorrectAnswer() {
        return a + b;
    }

}
