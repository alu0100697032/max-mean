package clases;

import java.util.ArrayList;

public class Problem {

	/**
	 * Atributos
	 */
	private ArrayList<ArrayList<Double>> distances; 	//matriz de distancias
	private ArrayList<Integer> nodesOutsideSolution;	//nodos fuera de la solucion 
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
	 * evaluate: devuelve el valor objetivo dada una solucion del problema
	 */
	public double evaluate(Solution solution) {
		double value = 0.0;
		//sumatorio de las aristas que conectan los nodos de la solucion
		for (int i = 0; i < solution.getSubset().size(); i++) {
			for (int j = i + 1; j < solution.getSubset().size(); j++) {
				if(solution.getPairActive(i, j))
					value += distances.get(i).get(j);
			}
		}
		//se divide entre el número de nodos de la solución y se devuelve el resultado
		return value/solution.getSolutionSize();
	}
	/**
	 * size: devuelve el tamaño del problema
	 */
	public int size(){
		return distances.size();
	}
	/**
	 * getDistance: devuelve una distancia entre dos nodos
	 */
	public double getDistance(int i, int j) {
		return distances.get(i).get(j);
	}
	/**
	 * setDistances: fija la matriz de distancias
	 */
	public void setDistances(ArrayList<ArrayList<Double>> distances) {
		this.distances = distances;
	}
	/**
	 * getNodesOutsideSolution: devuelve los nodos que no forman parte de la solucion
	 */
	public ArrayList<Integer> getNodesOutsideSolution() {
		return nodesOutsideSolution;
	}
}
