package hashCode2020.onofre;

import java.util.List;

public class Libreria {

	private int indiceLibreria;
	private int nuLibros;
	private int nuDiasSignUp;
	private int nuEscaneadosAlDia;
	private int puntuacion;
	private List<Integer> libros;

	public int getIndiceLibreria() {
		return indiceLibreria;
	}

	public void setIndiceLibreria(int indiceLibreria) {
		this.indiceLibreria = indiceLibreria;
	}

	public int getNuLibros() {
		return nuLibros;
	}

	public void setNuLibros(int nuLibros) {
		this.nuLibros = nuLibros;
	}

	public int getNuDiasSignUp() {
		return nuDiasSignUp;
	}

	public void setNuDiasSignUp(int nuDiasSignUp) {
		this.nuDiasSignUp = nuDiasSignUp;
	}

	public int getNuEscaneadosAlDia() {
		return nuEscaneadosAlDia;
	}

	public void setNuEscaneadosAlDia(int nuEscaneadosAlDia) {
		this.nuEscaneadosAlDia = nuEscaneadosAlDia;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Integer> getLibros() {
		return libros;
	}

	public void setLibros(List<Integer> libros) {
		this.libros = libros;
	}

}