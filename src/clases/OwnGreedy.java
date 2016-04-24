package clases;

import java.util.ArrayList;

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
		Solution solutionStar;
		do {
			solutionStar = (Solution) solution.clone();
			int bestNode = -1;
			double maxMd = solution.getMdValue();
			for (int i = 0; i < problem.size(); i++) {
				if(solution.getNodeActive(i)) {
					solution.setNodeFalse(i);
					if(problem.evaluate(solution) > solutionStar.getMdValue()) {
						maxMd = problem.evaluate(solution);
						bestNode = i;
					}
					solution.setNodeTrue(i);
				}
			}
			if(bestNode != -1) {
				solution.setNodeFalse(bestNode);
				solution.setMdValue(problem.evaluate(solution));
			}
		} while (!solution.getSubset().equals(solutionStar.getSubset()));
		return solution;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution) {
		for (int i = 0; i < problem.size(); i++) {
			solution.setNodeTrue(i);
		}
		solution.setMdValue(problem.evaluate(solution));
		problem.getNodesOutsideSolution().clear();
		System.out.println("Initial solution:\n" + solution.toString());
	}
}
