package hashCode2020.kuni.ramificacionypoda;

public class Nodo {
	
	int solucion[];
    int nivel;
    int puntos;
    
    int CI, BE, CS;

	public Nodo(int[] solucion, int nivel, int puntos) {
		this.solucion = solucion;
		this.nivel = nivel;
		this.puntos = puntos;
	}
}
