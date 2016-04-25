package clases;

import java.util.ArrayList;
import java.util.Random;

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
		Solution solutionStar;
		initialSolution(problem, solution, kmax);
		//System.out.println("Initial solution: \n" + solution.toString());
		int k = 1;
		while(k <= kmax) {
			solutionStar = shake(problem, solution, k);
			if(problem.evaluate(solutionStar) > problem.evaluate(solution)) {
				solution = (Solution)solutionStar.clone();
				k = 1;
			}else {
				k++;
			}
		}
		return solution;
	}
	/**
	 * shake
	 */
	public Solution shake(Problem problem, Solution solution, int k){
		Solution solutionStar = (Solution)solution.clone();
		ArrayList<Integer> trues = getTrues(solutionStar);
		ArrayList<Integer> falses = getFalses(solutionStar);
		Random random = new Random();
		//comprobar que trues.size >= k
		//
		if(trues.size() < problem.size()) {
			for (int i = 0; i < k; i++) {
				int rt = (int)(random.nextDouble() * trues.size());
				int rf = (int)(random.nextDouble() * falses.size());
				//System.out.println("rt: " + rt + " rf: " + rf);
				solutionStar.setNodeTrue(falses.get(rf));
				solutionStar.setNodeFalse(trues.get(rt));
				
				trues.add(falses.get(rf));
				falses.add(trues.get(rt));
				trues.remove(rt);
				falses.remove(rf);
				
				//System.out.println("Trues: " + trues.toString());
				//System.out.println("Falses: " + falses.toString());
			}
		}
		solutionStar.setMdValue(problem.evaluate(solutionStar));
		//System.out.println("Shake: \n" + solutionStar.toString());
		return solutionStar;
	}
	/**
	 * initialSolution
	 */
	public void initialSolution(Problem problem, Solution solution, int kmax){
		Random random = new Random();
		int initialNodes = (int)random.nextDouble() * (problem.size()-1) + 2;
		for (int i = 0; i < initialNodes; i++) {
			int randomNode = (int)random.nextDouble() * problem.size();
			problem.getNodesOutsideSolution().remove((Object)randomNode);
			solution.setNodeTrue(randomNode);
		}
		if(solution.getSolutionSize() <= kmax) {
			for (int i = 0; i < kmax; i++) {
				problem.getNodesOutsideSolution().remove((Object)i);
				solution.setNodeTrue(i);
			}
		}
		//fija el valor objetivo de la solucion actual
		solution.setMdValue(problem.evaluate(solution));
	}
	/**
	 * getFalses: obtiene los nodos que no estan en la solucion
	 */
	public ArrayList<Integer> getFalses(Solution solution) {
		ArrayList<Integer> falses = new ArrayList<>();
		for (int i = 0; i < solution.getSubset().size(); i++) {
			if(!solution.getNodeActive(i))
				falses.add(i);
		}
		return falses;
	}
	/**
	 * getTrues: obtiene los nodos que estan en la solucion
	 */
	public ArrayList<Integer> getTrues(Solution solution) {
		ArrayList<Integer> trues = new ArrayList<>();
		for (int i = 0; i < solution.getSubset().size(); i++) {
			if(solution.getNodeActive(i))
				trues.add(i);
		}
		return trues;
	}
}
