import org.jpl7.Query;
import org.jpl7.Term;

/**
 * This class solves the logic puzzle presented on the main frame by running the
 * logicpuzzle.pl script.
 */
public class PuzzleSolver {

	private String answer;

	// Solves the puzzle and stores the answer in the string answer. 
	public void solve() {
		String t1 = "consult('logicpuzzle.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
		//
		String t2 = "test_puzzle(test, X)";
		System.out.println("The solution of " + t2 + ": " + Query.oneSolution(t2).get("X"));
		Term ans = Query.oneSolution(t2).get("X");
		answer = ans.toString();
	}

	// Returns the answer to the logic puzzle. 
	public String getAnswer() {
		return answer;
	}

}
