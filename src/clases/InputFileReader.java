package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.Sides;

public class InputFileReader {

	/** 
	 * Atributes
	 */
	private ArrayList<ArrayList<Double>> matrizDistancias;
	
	/**
	 * Constructor: ReadInputFile
	 */
	public InputFileReader(String fileName) {
		String line = "";
		int i = 0;
		int j = 1;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			int size = Integer.parseInt(br.readLine());
			initializeDistances(size);
			while ((line = br.readLine()) != null){
				insertValue(Double.parseDouble(line), i, j);
				j++;
				if(j >= size){ 
					i++;
					j = i + 1;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param br
	 */
	public void initializeDistances(int size){
		matrizDistancias = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			matrizDistancias.add(new ArrayList<>());
			for (int j = 0; j < size; j++) {
				matrizDistancias.get(i).add(0.0);
			}
		}		
	}
	/**
	 * parseLine
	 * @param line
	 */
	public void insertValue(Double value, int i, int j){
		matrizDistancias.get(i).set(j, value);
		matrizDistancias.get(j).set(i, value);
	}
	/**
	 * showMatriz
	 */
	public void showMatriz(){
		for (int i = 0; i < matrizDistancias.size(); i++) {
			for (int j = 0; j < matrizDistancias.get(i).size(); j++) {
				System.out.print(matrizDistancias.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<Double>> getDistancias(){
		return matrizDistancias;
	}
}
