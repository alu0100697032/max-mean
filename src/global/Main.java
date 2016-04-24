package global;

import clases.GRASP;
import clases.Greedy;
import clases.InputFileReader;
import clases.Multiboot;
import clases.Problem;
import clases.Solution;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputFileReader fileReader = new InputFileReader("src/files/test1.txt");
		fileReader.showMatriz();
		Problem problem = new Problem(fileReader.getDistancias());
		Greedy greedy = new Greedy();
		Solution greedySolution = greedy.solve(problem);
		System.out.println("Greedy:\n" + greedySolution.toString());
		GRASP grasp = new GRASP();
		System.out.println("***************GRASP***************\n");
		Solution graspSolution = grasp.solve(problem, 3);
		System.out.println(graspSolution.toString());
		Multiboot multiBoot = new Multiboot();
		System.out.println("***************Multiboot***************\n");
		Solution multiBootSolution = multiBoot.solve(problem, 5);
		System.out.println(multiBootSolution.toString());	
	}
}
