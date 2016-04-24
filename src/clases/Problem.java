package clases;

import java.util.ArrayList;

public class Problem {

	/**
	 * Atributos
	 */
	private ArrayList<ArrayList<Double>> distances;
	private ArrayList<Integer> nodesOutsideSolution;
	/**
	 * Constructor: Problem
	 */
	public Problem(ArrayList<ArrayList<Double>> distances){
		setDistances(distances);
		nodesOutsideSolution = new ArrayList<>();
		for (int i = 0; i < distances.size(); i++) {
			nodesOutsideSolution.add(i);
		}
	}
	/**
	 * evaluate
	 */
	public double evaluate(Solution solution) {
		double value = 0.0;
		for (int i = 0; i < solution.getSubset().size(); i++) {
			for (int j = i + 1; j < solution.getSubset().size(); j++) {
				if(solution.getPairActive(i, j))
					value += distances.get(i).get(j);
			}
		}
		return value/solution.getSolutionSize();
	}
	/**
	 * size
	 */
	public int size(){
		return distances.size();
	}
	/**
	 * getDistance
	 */
	public double getDistance(int i, int j) {
		return distances.get(i).get(j);
	}
	/**
	 * setDistances
	 */
	public void setDistances(ArrayList<ArrayList<Double>> distances) {
		this.distances = distances;
	}
	/**
	 * getNodesOutsideSolution
	 */
	public ArrayList<Integer> getNodesOutsideSolution() {
		return nodesOutsideSolution;
	}
}
