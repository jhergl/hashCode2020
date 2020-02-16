package hashCode2020;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		char matriz [][] = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(//b_small.in//c_medium.in//d_big.in
					"/Users/Jesus/Downloads/d_big.in"));
			String line = reader.readLine();
			int lineN = 0;
			int rows = 0;
			int row = 0;
			int column = 0;
			while (line != null) {
				//read first line to take args
				if(lineN==0) {
					String[] splited = line.split("\\s+");
					lineN++;
					row =Integer.parseInt(splited[0]);
					column = Integer.parseInt(splited[1]);
					matriz = new char [row][column];	

				}
				else {
					for (int i = 0; i < line.length(); i++) {
						matriz[rows][i]=line.charAt(i);
					}
					rows++;
				}
				// read next line
				line = reader.readLine();
			}
			//read our matrix
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.print(matriz[i][j]);
				}
				System.out.print("\n");
			}
			reader.close();
		
			List<String> finalSolution = new ArrayList<String>();
			
			if(true){
				System.out.println("SOLUCION GENERAL VALIDA!!");
				Utils.writeFile("/Users/Jesus/Downloads/nombreFichero.out", finalSolution);
				System.out.println("SCORE->"+"valor de la solucion");
			}else{
				System.out.println("SOLUCION GENERAL NO VALIDA");
				Utils.writeFile("/Users/Jesus/Downloads/ERROR_EN_SOLUCION.out", finalSolution);
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
