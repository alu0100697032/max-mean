/**
 * File name:Multiboot.java
 * Package name: clases
 * Proyect name: max-mean
 */
package clases;

public class Multiboot {
	/** 
	 * Atributes
	 */
	public Multiboot() {
		
	}
	/**
	 * solve: ejecuta el algoritmo
	 */
	public Solution solve(Problem problem, int iterations) {
		Solution solution = new Solution(problem.size());
		Solution solutionStar;
		GRASP grasp = new GRASP();
		int x = 0;
		//ejecutamos x veces nuestro algoritmo GRASP
		while(x < iterations) {
			solutionStar = grasp.solve(problem, 3);
			//si la solucion obtenida despues de ejecutar el algoritmo mejora la actual, actualizamos
			if(solutionStar.getMdValue() > solution.getMdValue())
				solution = (Solution)solutionStar.clone();
			x++;
		}
		return solution;
	}
}
