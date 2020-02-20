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
			String [] nombreFichero = {"a_example","b_read_on","c_incunabula","d_tough_choices","e_so_many_books","f_libraries_of_the_world"};
			
			for (int k = 0; k < nombreFichero.length; k++) {
				
				
				reader = new BufferedReader(new FileReader(//b_small.in//c_medium.in//d_big.in
						"C:/Users/jesherna/Desktop/HASHCODE/"+nombreFichero[k]+".txt"));
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
					l.setIndiceLibreria(i);
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
			
				Utils.writeFile(Utils.solucionLineal(nuDiasEscanear, librerias, puntacionLibro), "C:/Users/jesherna/Desktop/HASHCODE/SOLUCIONES/"+nombreFichero[k]+".txt");
				
			
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
