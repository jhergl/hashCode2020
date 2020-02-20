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
					"C:/Users/jesherna/Desktop/HASHCODE/a_example.txt"));
			String line = reader.readLine();
			int lineN = 0;
			int nuLibros = 0;
			int nuLibrerias = 0;
			int nuDiasEscanear = 0;
			int [] puntacionLibro = null;
			
			//read first line to take args
			if(lineN==0) {
				String[] splited = line.split("\\s+");
				nuLibros = Integer.parseInt(splited[0]);
				nuLibrerias = Integer.parseInt(splited[1]);
				nuDiasEscanear = Integer.parseInt(splited[2]);

			}
			Libreria [] librerias = new Libreria [nuLibrerias];
			line = reader.readLine();
			lineN++;
			if(lineN==1) {
				String[] splited = line.split("\\s+");
				puntacionLibro = new int[nuLibros];
				int i = 0;
				for(String str: splited) {
					puntacionLibro[i] = Integer.parseInt(str);
					i++;
				}
			}
			//Cargamos librerias
			for(int i = 0; i<nuLibrerias;i++) {
				line = reader.readLine();
				String[] splited = line.split("\\s+");
				Libreria l =  new Libreria();
				l.setNuLibros(Integer.parseInt(splited[0]));
				l.setNuDiasSignUp(Integer.parseInt(splited[1]));
				l.setNuEscaneadosAlDia(Integer.parseInt(splited[2]));
				int [] librosLibreria = new int [l.getNuLibros()];
				line = reader.readLine();
				splited = line.split("\\s+");
				for(int j = 0; j<l.getNuLibros();j++) {
					librosLibreria[j]=Integer.parseInt(splited[j]);
				}
				l.setLibros(librosLibreria);
				librerias[i]= l;
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
