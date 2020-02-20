package hashCode2020;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

	public static void writeFile(List<LibreriaSolucion> lines, String tipo) throws FileNotFoundException {

		PrintWriter escribir = new PrintWriter(tipo);
		escribir.println(lines.size());

		for (int i = 0; i < lines.size(); i++) {

			escribir.println(lines.get(i).getIndiceLibreria() + " " + lines.get(i).getLibros().length);

			String linea = "";
			for (int j = 0; j < lines.get(i).getLibros().length; j++) {
				linea += lines.get(i).getLibros()[j] + " ";
			}
			escribir.println(linea.trim());
		}
		escribir.close();

	}

	public static List<LibreriaSolucion> solucionLineal(int nuDiasEscanear, Libreria[] librerias,
			int[] puntacionLibro) {
		List<LibreriaSolucion> solucion = new ArrayList<LibreriaSolucion>();
		Set<Integer> librosEscaneados = new HashSet<Integer>();
		List<Libreria> libs = Arrays.asList(librerias);
		// Ordenamos las librerias
		libs = libs.stream().sorted((o1, o2) -> o1.getNuDiasSignUp() - o2.getNuDiasSignUp())
				.collect(Collectors.toList());

		libs.forEach(l -> {
			for (int i = 0; i < l.getLibros().length; i++) {
				if (!librosEscaneados.contains(l.getLibros()[i])) {
					LibreriaSolucion ls = new LibreriaSolucion();
					ls.setIndiceLibreria(l.getIndiceLibreria());
					ls.setLibros(l.getLibros());
					ls.setNuLibrosEnviados(l.getLibros().length);
					solucion.add(ls);
					break;
				}
			}
		});

		return solucion;
	}

	public static List<LibreriaSolucion> solucionLineal2(int nuDiasEscanear, Libreria[] librerias,
			int[] puntacionLibro) {
		List<LibreriaSolucion> solucion = new ArrayList<LibreriaSolucion>();
		Set<Integer> librosEscaneados = new HashSet<Integer>();
		List<Libreria> libs = Arrays.asList(librerias);
		// Ordenamos las librerias
		libs = sort(libs);

		libs.forEach(l -> {
			for (int i = 0; i < l.getLibros().length; i++) {
				if (!librosEscaneados.contains(l.getLibros()[i])) {
					LibreriaSolucion ls = new LibreriaSolucion();
					ls.setIndiceLibreria(l.getIndiceLibreria());
					ls.setLibros(l.getLibros());
					ls.setNuLibrosEnviados(l.getLibros().length);
					solucion.add(ls);
					break;
				}
			}
		});

		return solucion;
	}

	public static List<Libreria> sort(List<Libreria> librerias) {

		return librerias.stream().sorted((o1, o2) -> {

			return (o1.getPuntuacion() / (o1.getNuDiasSignUp() + o1.getNuLibros() / o1.getNuEscaneadosAlDia()))
					- (o2.getPuntuacion() / (o2.getNuDiasSignUp() + o2.getNuLibros() / o2.getNuEscaneadosAlDia()));

		}).collect(Collectors.toList());
	}

}
