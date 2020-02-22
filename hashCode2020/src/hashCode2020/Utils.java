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
		//Ordenamos las librerias 
		libs = libs.stream()
				.sorted((o1, o2) ->   o1.getNuEscaneadosAlDia()-o2.getNuEscaneadosAlDia())
				.collect(Collectors.toList());
		
		libs.forEach(l->{
			for(int i = 0; i<l.getLibros().length;i++) {
				if(!librosEscaneados.contains(l.getLibros()[i])) {
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
	
	
	
	public static List<LibreriaSolucion> solucionLineal3(int nuDiasEscanear, Libreria [] librerias, int [] puntacionLibro){
		List<LibreriaSolucion> solucion = new ArrayList<LibreriaSolucion>();
		Set<Integer> librosEscaneados= new HashSet<Integer>();
		List<Libreria> libs = Arrays.asList(librerias);
		//Ordenamos las librerias 
		libs = libs.stream()
				.sorted((o1, o2) -> o1.getNuDiasSignUp() - o2.getNuDiasSignUp())
				.collect(Collectors.toList());
		
		libs.forEach(l->{
			for(int i = 0; i<l.getLibros().length;i++) {
				if(!librosEscaneados.contains(l.getLibros()[i])) {
					LibreriaSolucion ls = new LibreriaSolucion();
					ls.setIndiceLibreria(l.getIndiceLibreria());
					int nuLibrosNoEnviados = 0;
					for(int j = 0; j<l.getLibros().length;j++) {
						if(!librosEscaneados.contains(l.getLibros()[j])) {
							nuLibrosNoEnviados++;
						}
					}
					int [] librosNoEnviados = new int[nuLibrosNoEnviados];
					int k = 0;
					for(int j = 0; j<l.getLibros().length;j++) {
						if(!librosEscaneados.contains(l.getLibros()[j])) {
							librosNoEnviados[k] = l.getLibros()[j];
							librosEscaneados.add(l.getLibros()[j]);
							k++;
						}
					}
					ls.setLibros(librosNoEnviados);
					ls.setNuLibrosEnviados(librosNoEnviados.length);
					solucion.add(ls);
					break;
				}
			}
		});
		return solucion;
	}
	
	
	
	

	public static List<Libreria> sort(List<Libreria> librerias) {

		return librerias.stream().sorted((o1, o2) -> {

			return (o2.getPuntuacion() / (o2.getNuDiasSignUp()))
					- (o1.getPuntuacion() / (o1.getNuDiasSignUp()));
//			return o1.getPuntuacion()-o1.getNuDiasSignUp() - o2.getPuntuacion()+o2.getNuDiasSignUp();
			
		}).collect(Collectors.toList());
	}
	
	public static List<Integer> sort(List<Integer> libros,int[] puntacionLibro) {

		return libros.stream().sorted((o1, o2) -> {
			return (puntacionLibro[o2])	- (puntacionLibro[o1]);			
		}).collect(Collectors.toList());
	}
	
	
	public static List<LibreriaSolucion> solucionConRecalculos(int nuDiasEscanear, Libreria[] librerias,
			int[] puntacionLibro) {
		List<LibreriaSolucion> solucion = new ArrayList<LibreriaSolucion>();
		Set<Integer> librosEscaneados = new HashSet<Integer>();
		List<Libreria> libs = new ArrayList<Libreria>(Arrays.asList(librerias));

		//Ordenamos los libros de cada libreria por orden de puntuacion
		ordenarLibrosEnLibrerias(libs, puntacionLibro);
		
		//Ordenamos las librerias 
		while (libs.size()>0) {
			int index = getIndexLibreriaAnadir(libs, puntacionLibro, librosEscaneados);
			
			if(index==-1) {
				break;
			}
			
			for(int i = 0; i<libs.size();i++) {
				if(libs.get(i).getIndiceLibreria() == index) {
					LibreriaSolucion ls = new LibreriaSolucion();
					ls.setIndiceLibreria(libs.get(i).getIndiceLibreria());
					int nuLibrosNoEnviados = 0;
					for(int j = 0; j<libs.get(i).getLibros().length;j++) {
						if(!librosEscaneados.contains(libs.get(i).getLibros()[j])) {
							nuLibrosNoEnviados++;
						}
					}
					int [] librosNoEnviados = new int[nuLibrosNoEnviados];
					int k = 0;
					for(int j = 0; j<libs.get(i).getLibros().length;j++) {
						if(!librosEscaneados.contains(libs.get(i).getLibros()[j])) {
							librosNoEnviados[k] = libs.get(i).getLibros()[j];
							librosEscaneados.add(libs.get(i).getLibros()[j]);
							k++;
						}
					}
					ls.setLibros(librosNoEnviados);
					ls.setNuLibrosEnviados(librosNoEnviados.length);
					solucion.add(ls);
					index = i;
					break;
				}
			}
			libs.remove(index);
		}
		return solucion;
	}
	
	public static int getIndexLibreriaAnadir(List<Libreria> libs, int[] puntacionLibro, Set<Integer> librosEscaneados) {
		Integer index= null;
		recalculaEvaluaciones(libs, librosEscaneados, puntacionLibro);
		libs = sort(libs);
		for(int j = 0; j<libs.size();j++) {
			for(int i = 0; i<libs.get(j).getLibros().length;i++) {
				if(!librosEscaneados.contains(libs.get(j).getLibros()[i])) {
					index = libs.get(j).getIndiceLibreria();
					break;
				}
			}
			if(index != null) {
				break;
			}
		}
		if(index == null) {
			return -1;
		}
		return index;
	}
	
	public static void recalculaEvaluaciones(List<Libreria> libs, Set<Integer> librosEscaneados,int[] puntacionLibro) {

		libs.forEach(l->{
			List<Integer> nuevaListaLibros = new ArrayList<Integer>();
			for (Integer integer : l.getLibros()) {
				if(!librosEscaneados.contains(integer)) {
					nuevaListaLibros.add(integer);
				}
			}
			int[]nuevoArray = new int[nuevaListaLibros.size()];
			for (int i = 0;i<nuevaListaLibros.size();i++) {
				nuevoArray[i] = nuevaListaLibros.get(i);
			}
			l.setLibros(nuevoArray);
			l.setNuLibros(nuevoArray.length);
			int puntuacion = 0;
			for (int j = 0; j < l.getNuLibros(); j++) {
				int idLibro = nuevoArray[j];
				puntuacion += puntacionLibro[idLibro];
			}
			l.setPuntuacion(puntuacion);
			
		});

	}
	
	
	public static void ordenarLibrosEnLibrerias(List<Libreria> libs,int[] puntacionLibro) {
		for (Libreria l : libs) {
			List<Integer> list = new ArrayList<Integer>();
			for(int i =0;i<l.getLibros().length;i++) {
				list.add(l.getLibros()[i]);
			}
			list = sort(list, puntacionLibro);
			int[] newArray = new int[list.size()];
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = list.get(i).intValue();
			}
			l.setLibros(newArray);
		}
	}

}
