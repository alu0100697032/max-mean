package clases;

import java.util.ArrayList;

public class Solution implements Cloneable{

	/**
	 * Atributos
	 */
	private double mdValue;				//valor objetivo
	private ArrayList<Boolean> subSet;	//array de booleanos que representa la solucion
	private int solutionSize;			//numero de nodos dentro de la solucion
	/**
	 * Constructor: Solution
	 */
	public Solution(int size){
		mdValue = 0;
		solutionSize = 0;
		subSet = new ArrayList<Boolean>();
		for (int i = 0; i < size; i++) {
			subSet.add(false);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String toS = "\n";
		toS += "Valor objetivo:" + mdValue + "\nSubconjunto:\n";
		for (int i = 0; i < subSet.size(); i++) {
			toS += subSet.get(i) + ", ";
		}
		toS += "\n";
		return toS;
	}
	/**
	 * setMdValue: fija el valor objetivo
	 */
	public void setMdValue(double value){
		mdValue = value;
	}
	/**
	 * getMdValue: devuelve el valor objetivo
	 */
	public double getMdValue() {
		double aux = mdValue;
		return aux;
	}
	/**
	 * setNodeActive: fija un nodo como dentro de la solucion
	 */
	public void setNodeTrue(int node){
		if(!subSet.get(node)) {
			subSet.set(node, true);
			solutionSize++;
		}
	}
	/**
	 * setNodeFalse: fija un nodo como fuera de la solucion
	 */
	public void setNodeFalse(int node){
		if(subSet.get(node)) {
			subSet.set(node, false);
			solutionSize--;
		}
	}
	/**
	 * getNodeActive: devuelve si un nodo está o no en la solucion
	 */
	public boolean getNodeActive(int node) {
		return subSet.get(node);
	}
	/**
	 * getPairActive: devuelve si el par de nodos dado están en la solucion
	 */
	public boolean getPairActive(int i, int j) {
		if(subSet.get(i) == true && subSet.get(j) == true)
			return true;
		else 
			return false;
	}
	/**
	 * getSubset: devuelve el array que representa la solucion
	 */
	public ArrayList<Boolean> getSubset(){
		return subSet;
	}
	/**
	 * getSolutionSize: devuelve el número de nodos dentro de la solución
	 */
	public int getSolutionSize() {
		int aux = solutionSize;
		return aux;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Solution solution = null;
		try {
			solution = (Solution)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		solution.subSet = (ArrayList<Boolean>)solution.subSet.clone();
		return solution;
	}
}
