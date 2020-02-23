package hashCode2020.kuni;

public class Backtracking {
	
	private static final int MENOS_INFINITO = -9999;
	

    static int nivel;
	
	/* Generamos un árbol combinatorio */
	private static void Generar (int nivel,int s[]/*, int &peso_act , int pesos_personas[]*/) {
//	    if (s[nivel]==-1) {
//	        if (nivel==0)
	            s[nivel]++;
//	        else
//	            s[nivel]=s[nivel-1]+1;
//	        peso_act = peso_act + pesos_personas[s[nivel]];
//	    }
//	    else {
//	        s[nivel]++;
//	        peso_act = peso_act + pesos_personas[s[nivel]] - pesos_personas[s[nivel]-1];
//	    }
	}

	private static  boolean Criterio (int s[], int totalLibs){
	    return s[nivel]<totalLibs && nivel<totalLibs-1 /*&& nivel+(n-s[nivel])>=n/2*/;
	}

	private static boolean Solucion (int s[]){
		return true;
	}

	private static boolean MasHermanos(int nivel, int s[], int n){
	    return (s[nivel]<n-1);
	}

	public static void Retroceder (int s[]/*, int pesos_personas[], int &peso_act*/){
//	    peso_act-=pesos_personas[s[nivel]]; 
	    s[nivel] = -1;
	    nivel--;
	}

	public static void backtracking(Library  libs[] ,int totalLibs , int totalDays) {
		/* Inicialización */
	    nivel = 0;
	    int s[] = new int[totalLibs];
	    for (int i=0; i<totalLibs;i++){
	        s[i]=-1;
	    }
	    int peso_act=0;
	    int  voa = MENOS_INFINITO;
	    int[] soa;
	    boolean fin = false;
	    
	    /* Algoritmo */
        do {
            Generar(nivel, s/*, peso_act, libs*/);
            if (Solucion(s) && (voa<peso_act)) {
//                StringBuilder sb = new StringBuilder();
//                for (int i : s) {
//                	sb.append(i);
//                	sb.append(" ");
//    			}
//                System.out.println(sb);
//                voa = peso_act;
//                if (voa==peso_max) 
//                    fin = true;
            }
            if (Criterio(s, totalLibs) /*&& peso_act<=peso_max*/){
                nivel++;
            }
            else {
                while((nivel>-1) && (!MasHermanos(nivel, s, totalLibs))){
                    Retroceder(s/*, pesos_personas, peso_act*/);
                }
            }
        } while(nivel>-1 && !fin);
	}

}
