package questions;
/**
 * OtherQuestion is a class that implements the interface IntQuestions
 * It creates a question that has an integer for answer.
 * @author Antony, Abdelkader
 *
 */
public class OtherQuestion implements quiz.IntQuestions {

    private String question;
    private int answer;  
    
    /**
     * 
     * @param question
     * @param answer
     */
    public OtherQuestion(String question, int answer) { // constructor
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns the question asked
     * @return String : question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer of the question
     * @return int : result of the question
     */
    public int getCorrectAnswer() {
        return answer;
    }

}
