import org.jpl7.Query;
import org.jpl7.Term;

public class PuzzleSolver {
	
	private String answer;
	
	public void solve() {
		String t1 = "consult('logicpuzzle.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
		//
		String t2 = "test_puzzle(test, X)";
		System.out.println("The solution of " + t2 + ": " + Query.oneSolution(t2).get("X"));
		Term ans = Query.oneSolution(t2).get("X");
		answer = ans.toString();
	}
	
	public String getAnswer() {
		return answer;
	}

}
