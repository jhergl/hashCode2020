package hashCode2020;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
	
	public static void writeFile(List<LibreriaSolucion> lines,String tipo) throws FileNotFoundException {
	
		PrintWriter escribir= new PrintWriter(tipo);
		escribir.println(lines.size());
		
		for (int i = 0; i < lines.size(); i++) {
			
			escribir.println(lines.get(i).getIndiceLibreria()+" "+lines.get(i).getLibros().length);
			
			for (int j = 0; j < lines.get(i).getLibros().length; j++) {
				escribir.print(lines.get(i).getLibros()[j]);
			}
			escribir.println();
			
		}
		
		
	}


}
