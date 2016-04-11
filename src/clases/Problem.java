package clases;

import java.util.ArrayList;

public class Problem {

	/**
	 * Atributos
	 */
	private ArrayList<ArrayList<Double>> distances;
	private ArrayList<Integer> nodesOutsideSolution;
	/**
	 * Constructor
	 * @param distances
	 */
	public Problem(ArrayList<ArrayList<Double>> distances){
		setDistances(distances);
		nodesOutsideSolution = new ArrayList<>();
		for (int i = 0; i < distances.size(); i++) {
			nodesOutsideSolution.add(i);
		}
	}
	/**
	 * getDistance from i to j
	 * @param i
	 * @param j
	 * @return
	 */
	public double getDistance(int i, int j) {
		return distances.get(i).get(j);
	}
	/**
	 * setDistances
	 * @param distances
	 */
	public void setDistances(ArrayList<ArrayList<Double>> distances) {
		this.distances = distances;
	}
	/**
	 * getNumberOfNodes
	 * @return
	 */
	public int getNumberOfNodes(){
		return distances.size();
	}
	public ArrayList<Integer> getNodesOutsideSolution() {
		return nodesOutsideSolution;
	}
}
