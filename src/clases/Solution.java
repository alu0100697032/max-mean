package clases;

import java.util.ArrayList;

public class Solution implements Cloneable{

	/**
	 * Atributos
	 */
	private double mdValue;
	private ArrayList<Boolean> subSet;
	private int solutionSize;
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
	/**
	 * setMdValue
	 */
	public void setMdValue(double value){
		mdValue = value;
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
	 * getMdValue
	 */
	public double getMdValue() {
		double aux = mdValue;
		return aux;
	}
	/**
	 * setNodeActive
	 */
	public void setNodeTrue(int node){
		subSet.set(node, true);
		solutionSize++;
	}
	/**
	 * setNodeFalse
	 */
	public void setNodeFalse(int node){
		subSet.set(node, false);
		solutionSize--;
	}
	/**
	 * getNodeActive
	 */
	public boolean getNodeActive(int node) {
		return subSet.get(node);
	}
	/**
	 * getPairActive
	 */
	public boolean getPairActive(int i, int j) {
		if(subSet.get(i) == true && subSet.get(j) == true)
			return true;
		else 
			return false;
	}
	/**
	 * getSubset
	 */
	public ArrayList<Boolean> getSubset(){
		return subSet;
	}
	/**
	 * getSolutionSize
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
