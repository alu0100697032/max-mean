package clases;

import java.util.ArrayList;

public class VNS {

	/**
	 * Constructor
	 */
	public VNS(){
		
	}
	/**
	 * Solve: ejecuta el algoritmo
	 */
	public Solution solve(Problem problem, int kmax){
		Solution solution = new Solution(problem.size());
		initialSolution(problem, solution);
		shake(problem, solution, kmax);
		return solution;
	}
	/**
	 * shake
	 */
	public Solution shake(Problem problem, Solution solution, int kmax){
		return solution;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution){
		double max = 0.0;
		ArrayList<Integer> subSet = new ArrayList<>();
		//busca la arista de mayor coste
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
		//mete en la solucion los nodos que unen la arista obtenida anteriormente
		for (int i = 0; i < subSet.size(); i++) {
			problem.getNodesOutsideSolution().remove((Object)subSet.get(i));
			solution.setNodeTrue(subSet.get(i));
		}
		//fija el valor objetivo de la solucion actual
		solution.setMdValue(problem.evaluate(solution));
	}
}
