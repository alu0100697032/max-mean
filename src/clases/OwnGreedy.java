package clases;

public class OwnGreedy {

	/**
	 * Constructor: OwnGreedy
	 */
	public OwnGreedy(){
		
	}
	/**
	 * solve: ejecuta el algoritmo
	 */
	public Solution solve(Problem problem){
		Solution solution = new Solution(problem.size());
		initialSolution(problem, solution);
		Solution solutionStar;
		do {//repetir
			solutionStar = (Solution) solution.clone();
			int bestNode = -1;
			double maxMd = solution.getMdValue();
			//quitar nodos de la solucion para ver si mejora el valor objetivo
			for (int i = 0; i < problem.size(); i++) {
				if(solution.getNodeActive(i)) {
					solution.setNodeFalse(i);
					if(problem.evaluate(solution) > solutionStar.getMdValue()) {//buscar el que más mejore el valor objetivo
						maxMd = problem.evaluate(solution);
						bestNode = i;
					}
					solution.setNodeTrue(i);
				}
			}
			//si mejora lo eliminamos de la solucion y recalculamos el valor objetivo
			if(bestNode != -1) {
				solution.setNodeFalse(bestNode);
				solution.setMdValue(problem.evaluate(solution));
			}
		} while (!solution.getSubset().equals(solutionStar.getSubset()));//mientras la solucion mejore
		return solution;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution) {
		//metemos todos los nodos en la solucion
		for (int i = 0; i < problem.size(); i++) {
			solution.setNodeTrue(i);
		}
		//calculamos el valor objetivo
		solution.setMdValue(problem.evaluate(solution));
		problem.getNodesOutsideSolution().clear();
		//System.out.println("Initial solution:\n" + solution.toString());
	}
}
