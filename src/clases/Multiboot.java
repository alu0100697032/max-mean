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
	 * solve
	 */
	public Solution solve(Problem problem, int iterations) {
		Solution solution = new Solution(problem.size());
		Solution solutionStar;
		GRASP grasp = new GRASP();
		int x = 0;
		while(x < iterations) {
			solutionStar = grasp.solve(problem, 3);
			if(solutionStar.getMdValue() > solution.getMdValue())
				solution = (Solution)solutionStar.clone();
			x++;
		}
		return solution;
	}
}
