package global;

import clases.Greedy;
import clases.InputFileReader;
import clases.Problem;
import clases.Solution;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputFileReader fileReader = new InputFileReader("src/files/test1.txt");
		fileReader.showMatriz();
		Problem problem = new Problem(fileReader.getDistancias());
		Greedy greedy = new Greedy();
		Solution solution = greedy.solve(problem);
		System.out.println(solution.toString());
	}

}
