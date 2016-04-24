package clases;

public class OwnGreedy {

	/**
	 * Constructor: OwnGreedy
	 */
	public OwnGreedy(){
		
	}
	/**
	 * solve
	 */
	public Solution solve(Problem problem){
		Solution solution = new Solution(problem.size());
		initialSolution(problem, solution);
		boolean stop = false;
		while (stop != true){
			
		}
		return solution;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution) {
		for (int i = 0; i < problem.size(); i++) {
			solution.setNodeTrue(i);
			problem.getNodesOutsideSolution().remove((Object)i);
		}
		solution.setMdValue(problem.evaluate(solution));
	}
}
