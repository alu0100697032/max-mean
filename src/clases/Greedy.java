package clases;

import java.util.ArrayList;

public class Greedy {

	/**
	 * Constructor
	 */
	public Greedy(){
		
	}
	/**
	 * solve
	 */
	public Solution solve(Problem problem){
		Solution solution = new Solution(problem.size());
		Solution solutionStar;
		initialSolution(problem, solution); // seleccionar la arista con mayor afinidad
		do{
			solutionStar = (Solution) solution.clone(); //S* = S
			int bestNode = -1;
			double maxMd = 0.0;
			//encontrar el vértice que maximiza md(S U {k})
			for (int i = 0; i < problem.size(); i++) {
				if(solution.getNodeActive(i)) {
					for (int j = 0; j < problem.getNodesOutsideSolution().size(); j++) {
						solution.setNodeTrue(problem.getNodesOutsideSolution().get(j));
						double maximumDispersion = problem.evaluate(solution);
						if(maximumDispersion > maxMd) {
							maxMd = maximumDispersion;
							bestNode = problem.getNodesOutsideSolution().get(j);
						}
						solution.setNodeFalse(problem.getNodesOutsideSolution().get(j));
					}
				}
			}
			//si mejora entonces actualizamos
			if(maxMd > solution.getMdValue()) {
				solution.setNodeTrue(bestNode);
				solution.setMdValue(maxMd);
				problem.getNodesOutsideSolution().remove((Object)bestNode);
			}
		}while(!solution.getSubset().equals(solutionStar.getSubset()));///repetir hasta que no mejore
		return solutionStar;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution){
		double max = 0.0;
		ArrayList<Integer> subSet = new ArrayList<>();
		//inicial subset
		for (int i = 0; i < problem.size(); i++) {
			for (int j = 0; j < problem.size(); j++) {
				if(problem.getDistance(i, j) > max){
					subSet.clear();
					max = problem.getDistance(i, j);
					subSet.add(i);
					subSet.add(j);
				}
			}
		}
		for (int i = 0; i < subSet.size(); i++) {
			problem.getNodesOutsideSolution().remove((Object)subSet.get(i));
			solution.setNodeTrue(subSet.get(i));
		}
		solution.setMdValue(problem.evaluate(solution));
	}
}
