package toshiro10.E102;

import java.util.TreeSet;

public class SetCalculator {
	/**
	 * This program is a very simple "set calculator" that can compute
	 * the intersection, union, and set difference of two sets of 
	 * non-negative integers.  Each line of the user's input contains two 
	 * such sets, separated by one of the operators +, *, or -, standing
	 * for union, intersection, and set difference respectively.  A set
	 * must be given in the form of a list of non-negative integers, separated
	 * by commas, and enclosed in square brackets.  For example:
	 * [1, 2, 3] + [4, 3, 10, 0].  Spaces can occur anywhere in the input.
	 * If an error is found in the input, the program will report it.
	 * The program ends when the user inputs an empty line.
	 *
	 * This program is mainly a demonstration of Sets.
	 */
	public static void main(String[] args) {
		System.out.println("Compute union, intersection or the difference between two sets of integers");
		System.out.println("Type your first set, add the operation you want and the second set");
		System.out.println("Please respect this synthax Ex : [1,2,3,4] + [7,5,6]"
				+ " , press enter when you're done");
		System.out.println("\nType your calcul:  ");
		while (true) {
			char ch;
	        System.out.print("\n? ");
	        TextIO.skipBlanks();
	        if (TextIO.peek() == '\n') {
	               // The input line is empty.  
	               // Exit the loop and end the program.
	        	break;
	        }
	        try {
	        	calc(); // Reads and processes one line of input.
	        }
	        catch (IllegalArgumentException e) {
	               // An error was found in the input line.
	        	System.out.println("Error in input: " + e.getMessage());
	            System.out.print("Discarding input: ");
	        }
	        do {  // Copy extra characters on line to output.  If there 
	               // was no error, then the only character that is copied
	               // is the end-of-line character.
	        	ch = TextIO.getAnyChar();
	            System.out.print(ch);
	        } while (ch != '\n');
	        
	        System.out.println("Or press \"Enter to exit the program\"");
		}

	}
	 /**
	    * Read a line of input, consisting of two sets separated by
	    * an operator.  Perform the operation and output the value.
	    * If any syntax error is found in the input, an
	    * IllegalArgumentException is thrown
	    */
   private static void calc() {

	   	TreeSet<Integer> set1, set2;  // The two sets of integers.
      	char operator;                // The operator, +, *, or -.

      	set1 = readSet(); // Read the first set.

      	TextIO.skipBlanks();
      	if (TextIO.peek() != '*' && TextIO.peek() != '+' 
                                         && TextIO.peek() != '-')
      		throw new IllegalArgumentException(
      				"Expected *, +, or  - after first set.");
      	operator = TextIO.getAnyChar(); // Read the operator.

      	set2 = readSet(); // Read the second set.

      	TextIO.skipBlanks();
      	if (TextIO.peek() != '\n')
      		throw new IllegalArgumentException("Extra unexpected input.");

      // Perform the operation.  This modifies set A to represent
      // the answer.  Display the answer by printing out A. The
      // output format for a set of integers is the same as the
      // input format used by this program.

      	if (operator == '+')
      		set1.addAll(set2);     // Union.
      	else if (operator == '*')
      		set1.retainAll(set2);  // Intersection.
      	else
      		set1.removeAll(set2);  // Set difference.
      
      	System.out.print("Value:  " + set1);

   	}
	private static TreeSet<Integer> readSet() {
		TreeSet<Integer> set = new TreeSet<Integer>();  // The set that will be read.
	
		TextIO.skipBlanks();
		if (TextIO.peek() != '[')
			throw new IllegalArgumentException("Expected '[' at the beginning of the set.");
		TextIO.getAnyChar(); // Read the '['.
	
	    TextIO.skipBlanks();
	    if (TextIO.peek() == ']') {
	          // The set has no integers.  This is the empty set, which
	          // is legal.  Return the value.
	       TextIO.getAnyChar(); // Read the ']'.
	       return set;
	    }
	
	    while (true) {
	            // Read the next integer and add it to the set.
	    	TextIO.skipBlanks();
	    	if (! Character.isDigit(TextIO.peek()))
	    		throw new IllegalArgumentException("Expected an integer.");
	    	int n = TextIO.getInt(); // Read the integer.
	    	set.add( new Integer(n) );
	        TextIO.skipBlanks();
	        if (TextIO.peek() == ']')
	        	break;  // ']' marks the end of the set.
	        else if (TextIO.peek() == ',')
	        	TextIO.getAnyChar(); // Read a comma and continue.
	        else
	            throw new IllegalArgumentException("Expected ',' or ']'.");
	      }
	
	    TextIO.getAnyChar(); // Read the ']' that ended the set.
	    return set;

   } // end readSet()
}
