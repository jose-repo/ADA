package aec1;

public class Main {
    private static final int[] origen = {0, 1}; // fila 0 columna 1
    private static final int[] destino = {3, 1}; // fila 3 columna 0

    public static void main(String[] args) {
        int[][] lab = {{1, 1, 0, 0}, {0, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}};
        algoritmo(lab, origen[0], origen[1]);;
    }

    public static boolean algoritmo(int[][] lab, int i, int j) {
        int derecha = j + 1;
        int izquierda = j - 1;
        int abajo = i + 1;
        int arriba = i - 1;

        // busca abajo
        if (lab.length > abajo) {
            if (lab[abajo][j] == 1) {
                System.out.println("abajo -> pos i [" + abajo + "] pos j [" + j + "]");
                if (destinoEncontrado(abajo,j)) {
                    j = origen[1];
                    return true;
                }
                algoritmo(lab, abajo, j);
                if (!esOrigen(i,j)) {
                    return true;
                }
            }
        }
        // busca a la derecha
         if (lab[i].length > derecha) {
            if (lab[i][derecha] == 1) {
                System.out.println("derecha -> pos i [" + i + "] pos j [" + derecha + "]");
                if (destinoEncontrado(i,derecha)) {
                    return true;
                }
                algoritmo(lab, i, derecha);
                if (!esOrigen(i,j)) {
                    return true;
                }
            }
        }
        // busca a la izquierda
        if (izquierda > -1) {
            if (lab[i][izquierda] == 1) {
                System.out.println("izquierda -> pos i [" + i + "] pos j [" + izquierda + "]");
                if (destinoEncontrado(i,izquierda)) {
                    return true;
                }
                algoritmo(lab, i, izquierda);
                if (!esOrigen(i,j)) {
                    return true;
                }
            }
        }
        // busca arriba
        if (arriba > -1) {
            if (lab[arriba][j] == 1) {
                System.out.println("arriba -> pos i [" + arriba + "] pos j [" + j + "]");
                if (destinoEncontrado(arriba,j)) {
                    return true;
                }
                algoritmo(lab, arriba, j);
                if (!esOrigen(i,j)) {
                    return true;
                }
            }
        }
        // si no me puedo mover, no hay salida
        return false;

    }

    private static boolean destinoEncontrado(int i, int j) {
        if (i == destino[0] && j == destino[1]) {
            System.out.println("camino encontrado");
            return true;
        }
        return false;
    }

    private static boolean esOrigen(int i, int j) {
        if (i == origen[0] && j == origen[1]) {
            return true;
        }
        return false;
    }
}
