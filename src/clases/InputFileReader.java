package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileReader {

	/** 
	 * Atributes
	 */
	private ArrayList<ArrayList<Integer>> matrizDistancias;
	
	/**
	 * Constructor: ReadInputFile
	 */
	public InputFileReader(String fileName) {
		String line = "";
		matrizDistancias = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null)
				parseLine(line);

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
	 * parseLine
	 * @param line
	 */
	public void parseLine(String line){
		ArrayList<Integer> lineValues = new ArrayList<>();
		String[] values = line.split(" ");
		for (int i = 0; i < values.length; i++) {
			lineValues.add(Integer.parseInt(values[i]));
		}
		matrizDistancias.add(lineValues);
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
	public ArrayList<ArrayList<Integer>> getDistancias(){
		return matrizDistancias;
	}
}
