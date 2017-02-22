package questions;
/**
 * SubstractionQuestion is a class that implements the interface IntQuestions
 * It creates a substraction question of two random numbers. The first number is between 0 to 51
 * and the second one between 0 to 50. The substraction result has to be positive.
 * @author Antony, Abdelkader
 *
 */
public class SubstractionQuestion implements quiz.IntQuestions{

    private int a, b;  // The numbers in the problem.

    public SubstractionQuestion() { // constructor
    	 
        do{
        	a = (int)(Math.random() * 50 + 1);
        	b = (int)(Math.random() * 50);
        }while(a<b);
        	
        
    }
    /**
     * Returns the question asked
     * @return String : question
     */
    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }
    /**
     * Returns the answer of the question
     * @return int : result of the question
     */
    public int getCorrectAnswer() {
        return a - b;
    }
}
