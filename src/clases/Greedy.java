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
	 * @param problem
	 * @return
	 */
	public Solution solve(Problem problem){
		Solution solution = new Solution();
		double currentSummation = initialSubSet(problem, solution);
		double improvedSumation = currentSummation;
		double improvedMD = currentSummation/(double)solution.size();
		int nodeToPutInSolution = -1;//indica el nodo a meter en la solucion
		do{
			if(nodeToPutInSolution > -1){//si se encontro una solucion que mejora la actual...actualizar
				solution.addNode(nodeToPutInSolution);
				currentSummation = improvedSumation;
				problem.getNodesOutsideSolution().remove((Object)nodeToPutInSolution);//quitar del array de nodos fuera de la solucion
			}
			solution.setMdValue(improvedMD);
			//recorrer los nodos de la solucion y unirlos a los que no están a ver si mejora
			for (int i = 0; i <solution.size(); i++) {
				for (int j= 0; j < problem.getNodesOutsideSolution().size(); j++) {
					if((currentSummation + problem.getDistance(solution.getNode(i), 
							problem.getNodesOutsideSolution().get(j)))/(double)(solution.size()+1) > improvedMD){
						
						improvedSumation = currentSummation + problem.getDistance(solution.getNode(i), 
								problem.getNodesOutsideSolution().get(j));
						improvedMD = (improvedSumation/(double)(solution.size()+1)); 
						nodeToPutInSolution = problem.getNodesOutsideSolution().get(j);
					}
				}
			}	
		}while(solution.getMdValue() < improvedMD);//repetir hasta que no mejore
		return solution;
	}
	/**
	 * initialSubSet
	 * @param problem
	 * @return
	 */
	public double initialSubSet(Problem problem, Solution solution){
		double max = 0.0;
		ArrayList<Integer> subSet = new ArrayList<>();
		//inicial subset
		for (int i = 0; i < problem.getNumberOfNodes(); i++) {
			for (int j = 0; j < problem.getNumberOfNodes(); j++) {
				if(problem.getDistance(i, j) > max){
					subSet.clear();
					max = problem.getDistance(i, j);
					subSet.add(i);
					subSet.add(j);
				}
			}
		}
		for (int i = 0; i < subSet.size(); i++) {
			problem.getNodesOutsideSolution().remove(subSet.get(i));
		}
		solution.setSubSet(subSet);
		return max;
	}
}
