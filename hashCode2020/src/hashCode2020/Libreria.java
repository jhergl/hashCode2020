package hashCode2020;

public class Libreria {

	private int indiceLibreria;
	private int nuLibros;
	private int nuDiasSignUp;
	private int nuEscaneadosAlDia;

	private int[] libros;

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

	public int[] getLibros() {
		return libros;
	}

	public void setLibros(int[] libros) {
		this.libros = libros;
	}

	public int getIndiceLibreria() {
		return indiceLibreria;
	}

	public void setIndiceLibreria(int indiceLibreria) {
		this.indiceLibreria = indiceLibreria;
	}
}
