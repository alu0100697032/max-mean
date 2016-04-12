package clases;

import java.util.ArrayList;

public class Solution {

	/**
	 * Atributos
	 */
	private double mdValue;
	private ArrayList<Boolean> subSet;
	/**
	 * Constructor
	 */
	public Solution(int size){
		mdValue = 0;
		subSet = new ArrayList<Boolean>();
		for (int i = 0; i < size; i++) {
			subSet.add(false);
		}
	}
	/**
	 * 
	 * @param distances
	 */
	public void setMdValue(ArrayList<ArrayList<Double>> distances){
		
	}
	/**
	 * 
	 */
	public String toString(){
		String toS = "";
		toS += "Valor objetivo:" + mdValue + "\nSubconjunto:\n";
		for (int i = 0; i < subSet.size(); i++) {
			toS += subSet.get(i) + ", ";
		}
		toS += "\n";
		return toS;
	}
	/**
	 * getMdValue
	 * @return
	 */
	public double getMdValue() {
		double aux = mdValue;
		return aux;
	}
	/**
	 * 
	 * @param node
	 */
	public void setNodeActive(int node){
		subSet.set(node, true);
	}
	/**
}
