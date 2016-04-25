package clases;
import java.util.ArrayList;
import java.util.Random;

/**
 * File name:GRASP.java
 * Package name: 
 * Proyect name: max-mean
 */

public class GRASP {
	/**
	 * Constructor: GRASP
	 */
	public GRASP() {
		
	}
	/**
	 * solve: ejecuta el algoritmo 
	 */
	public Solution solve(Problem problem, int lrcSize) {
		Solution solution = new Solution(problem.size());
		constructivePhase(problem, solution, lrcSize);//LRC
		Solution solutionStar = localSearch(problem, solution);//Busqueda local hasta que no mejore
		return solutionStar; 
	}
	/**
	 * constructivePhase: creamos la LRC y elegimos al azar un candidato
	 */
	public void constructivePhase(Problem problem, Solution solution, int lrcSize) {
		double max = 0.0;
		boolean stop = false;
		int iteration = 0;
		ArrayList<Integer> subSet = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lrc = new ArrayList<>();
		
		//creamos una LRC con los lrcDize número de candidatos dado
		while(iteration < lrcSize) {
			for (int i = 0; i < problem.size(); i++) {
				for (int j = 0; j < problem.size(); j++) {
					for (int k = 0; k < iteration; k++) {
						if((lrc.get(k).get(0) == i && lrc.get(k).get(1) == j)|| (lrc.get(k).get(0) == j && lrc.get(k).get(1) == i))
							stop = true;
					}
					if(!stop && problem.getDistance(i, j) > max){
						subSet.clear();
						max = problem.getDistance(i, j);
						subSet.add(i);
						subSet.add(j);
					}
					stop = false;
				}
			}
			lrc.add((ArrayList)subSet.clone());
			max = 0.0;
			subSet.clear();
			iteration++;
		}
		//mostramos a modo de informacion/debug
		/*System.out.println("1) LRC: \n");
		for (int i = 0; i < lrc.size(); i++) {
			System.out.println("LRC " + i + ": " + lrc.get(i).toString());
		}*/
		//elegir aleatoriamente un candidato
		Random random = new Random();
		int randomNumber = (int)(random.nextDouble() * lrcSize);
		/*System.out.println("\nElegido: " + randomNumber + "\n");
		System.out.println("Valor objetivo: " + problem.getDistance(lrc.get(randomNumber).get(0), lrc.get(randomNumber).get(1))/2);*/
		//construir la solucion
		int node1 = lrc.get(randomNumber).get(0);
		int node2 = lrc.get(randomNumber).get(1);
		solution.setNodeTrue(node1);
		solution.setNodeTrue(node2);
		solution.setMdValue(problem.evaluate(solution));
		problem.getNodesOutsideSolution().remove((Object)node1);
		problem.getNodesOutsideSolution().remove((Object)node2);
	}
	/**
	 * localSearch
	 */
	public Solution localSearch(Problem problem, Solution solution) {
		Solution solutionStar;
		//System.out.println("\n2) Busqueda local:");
		do {//repetir
			solutionStar = (Solution) solution.clone();
			int bestNode = -1;
			double maxMd = 0.0;
			//añadimos nodos a la solucion para ver si el valor objetivo mejora
			for (int i = 0; i < problem.size(); i++) {
				if(!solution.getNodeActive(i)) {
					solution.setNodeTrue(i);
					if(problem.evaluate(solution) > problem.evaluate(solutionStar)) {
						maxMd = problem.evaluate(solution);
						bestNode = i;
					}
					solution.setNodeFalse(i);
				}
			}
			//metemos en la solucion el que más mejore la solucion si es que hay alguno
			if(bestNode != -1) {
				solution.setNodeTrue(bestNode);
				solution.setMdValue(problem.evaluate(solution));
				problem.getNodesOutsideSolution().remove((Object)bestNode);
			}
		} while (!solution.getSubset().equals(solutionStar.getSubset()));//mientras la solucion mejore
		return solutionStar;
	}
}
