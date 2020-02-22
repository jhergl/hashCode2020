package hashCode2020.onofre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	static int nuLibros;
	static int nuLibrerias;
	static int nuDiasEscanear;
	static int diaActual;
	static String line;
	static Libreria libreria;
	static int[] puntuaciones;
	static List<Libreria> librerias;
	static List<LibreriaSolucion> solution;
	static Set<Integer> librosEscaneados;
	static BufferedReader reader;

	public static void main(String[] args) {

		try {
			for (String file : Arrays.asList(Constants.INPUT_FILES)) {
				loadData(file);
				process();
				writeSolution(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void process() {
		librosEscaneados = new HashSet<>();
		solution = new ArrayList<>();
		diaActual = 1;
		LibreriaSolucion ls;
		ordernarLibros();
		for (int i = 0; i < nuLibrerias; i++) {
			calcularPuntuacion();
			librerias = sort();
			libreria = librerias.get(0);
			librerias.remove(libreria);
			if (libreria.getNuLibros() == 0) {
				continue;
			}
			diaActual += libreria.getNuDiasSignUp();
			ls = new LibreriaSolucion();
			ls.setIndiceLibreria(libreria.getIndiceLibreria());
			ls.setLibros(libreria.getLibros());
			marcarLibrosEscaneados(ls);
			ls.setNuLibrosEnviados(libreria.getLibros().size());
			solution.add(ls);
		}

	}

	private static void ordernarLibros() {
		librerias.forEach(l -> {
			l.setLibros(l.getLibros().stream().sorted((o1, o2) -> puntuaciones[o2] - puntuaciones[o1])
					.collect(Collectors.toList()));
		});
	}

	private static void calcularPuntuacion() {
		librerias.forEach(l -> {
			int puntuacion = 0;
			int numLibs = 0;
			List<Integer> libs = new LinkedList<>(l.getLibros());
			for (int j = 0; j < l.getNuLibros(); j++) {
				if (librosEscaneados.contains(l.getLibros().get(j))) {
					libs.remove(l.getLibros().get(j));
				} else {
					numLibs++;
					puntuacion += puntuaciones[l.getLibros().get(j)];
				}
			}
			l.setLibros(libs);
			l.setNuLibros(numLibs);
			l.setPuntuacion(puntuacion);
		});
	}

	private static void marcarLibrosEscaneados(LibreriaSolucion ls) {
		for (Integer libro : ls.getLibros()) {
			librosEscaneados.add(libro);
		}
	}

	private static List<Libreria> sort() {
		return librerias.stream().sorted((o1, o2) -> {
			return (o2.getPuntuacion() / o2.getNuDiasSignUp() * o2.getNuEscaneadosAlDia())
					- (o1.getPuntuacion() / o1.getNuDiasSignUp() * o1.getNuEscaneadosAlDia());

		}).collect(Collectors.toList());
	}

	private static void writeSolution(String file) throws FileNotFoundException {
		String linea;
		PrintWriter writer = new PrintWriter(Constants.RESOURCES_URL + "out/" + file + ".txt");
		writer.println(solution.size());
		for (int i = 0; i < solution.size(); i++) {
			writer.println(solution.get(i).getIndiceLibreria() + " " + solution.get(i).getLibros().size());
			linea = "";
			for (int j = 0; j < solution.get(i).getLibros().size(); j++) {
				linea += solution.get(i).getLibros().get(j) + " ";
			}
			writer.println(linea.trim());
		}
		writer.close();
	}

	private static void loadData(String file) throws FileNotFoundException, IOException {

		String[] splited;
		List<Integer> librosLibreria;
		Libreria libreria;

		reader = new BufferedReader(new FileReader(Constants.RESOURCES_URL + file + ".txt"));
		line = reader.readLine();
		splited = line.split(" ");

		nuLibros = Integer.parseInt(splited[0]);
		nuLibrerias = Integer.parseInt(splited[1]);
		nuDiasEscanear = Integer.parseInt(splited[2]);
		puntuaciones = new int[nuLibros];
		librerias = new ArrayList<Libreria>(nuLibrerias);

		line = reader.readLine();
		splited = line.split(" ");

		for (int i = 0; i < nuLibros; i++) {
			puntuaciones[i] = Integer.parseInt(splited[i]);
		}

		for (int i = 0; i < nuLibrerias; i++) {
			line = reader.readLine();
			splited = line.split(" ");
			libreria = new Libreria();
			libreria.setIndiceLibreria(i);
			libreria.setNuLibros(Integer.parseInt(splited[0]));
			libreria.setNuDiasSignUp(Integer.parseInt(splited[1]));
			libreria.setNuEscaneadosAlDia(Integer.parseInt(splited[2]));

			librosLibreria = new LinkedList<>();
			line = reader.readLine();
			splited = line.split(" ");
			for (int j = 0; j < libreria.getNuLibros(); j++) {
				librosLibreria.add(Integer.parseInt(splited[j]));
			}
			libreria.setLibros(librosLibreria);
			librerias.add(libreria);
		}
	}

}
