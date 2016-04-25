package global;

import clases.GRASP;
import clases.Greedy;
import clases.InputFileReader;
import clases.Multiboot;
import clases.OwnGreedy;
import clases.Problem;
import clases.Solution;
import clases.VNS;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputFileReader fileReader = new InputFileReader("src/files/test10.txt");
		fileReader.showMatriz();
		Problem problem = new Problem(fileReader.getDistancias());
		long time_start, time_end;
		
		Greedy greedy = new Greedy();
		System.out.println("\n***************GREEDY***************");
		
		time_start = System.nanoTime();
		Solution greedySolution = greedy.solve(problem);
		time_end = System.nanoTime();
		
		System.out.println(greedySolution.toString());
		System.out.println("Tiempo ejecución: " + ( time_end - time_start )/1000000000.0 +" milliseconds");
		
		OwnGreedy ownGreedy = new OwnGreedy();
		System.out.println("\n***************OWN GREEDY***************");
		
		time_start = System.nanoTime();
		Solution ownGreedySolution = ownGreedy.solve(problem);
		time_end = System.nanoTime();
		
		System.out.println(ownGreedySolution.toString());
		System.out.println("Tiempo ejecución: " + ( time_end - time_start )/1000000000.0 +" milliseconds");
		
		GRASP grasp = new GRASP();
		System.out.println("\n***************GRASP***************");
		
		time_start = System.nanoTime();
		Solution graspSolution = grasp.solve(problem, 3);
		time_end = System.nanoTime();
		
		System.out.println(graspSolution.toString());
		System.out.println("Tiempo ejecución: " + ( time_end - time_start )/1000000000.0 +" milliseconds");
		
		Multiboot multiBoot = new Multiboot();
		System.out.println("\n***************MULTIBOOT***************");
		
		time_start = System.nanoTime();
		Solution multiBootSolution = multiBoot.solve(problem, 5);
		time_end = System.nanoTime();
		
		System.out.println(multiBootSolution.toString());	
		System.out.println("Tiempo ejecución: " + ( time_end - time_start )/1000000000.0 +" milliseconds");
		
		VNS vns = new VNS();
		System.out.println("\n***************VNS***************");
		
		time_start = System.nanoTime();
		Solution vnsSolution = vns.solve(problem, 2);
		time_end = System.nanoTime();
		
		System.out.println(vnsSolution.toString());	
		System.out.println("Tiempo ejecución: " + ( time_end - time_start )/1000000000.0 +" milliseconds");
	}
}
