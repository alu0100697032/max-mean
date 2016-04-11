package clases;

import java.util.ArrayList;

public class Solution {

	/**
	 * Atributos
	 */
	private double mdValue;
	private ArrayList<Integer> subSet;
	/**
	 * Constructor
	 */
	public Solution(){
		setMdValue(0);
		setSubSet(new ArrayList<>());
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
	 * setMdValue
	 * @param mdValue
	 */
	public void setMdValue(double mdValue) {
		this.mdValue = mdValue;
	}
	/**
	 * setSubSet
	 * @param subSet
	 */
	public void setSubSet(ArrayList<Integer> subSet) {
		this.subSet = subSet;
	}
	/**
	 * 
	 * @param node
	 */
	public void addNode(int node){
		subSet.add(node);
	}
	/**
	 * 
	 * @return
	 */
	public int getNode(int i){
		return subSet.get(i);
	}
	/**
	 * 
	 * @return
	 */
	public int size(){
		return subSet.size();
	}
}
