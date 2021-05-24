package aec2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final int origenFila = 0;
    private static final int origenColumna = 1;
    private static final int destinoFila = 9;
    private static final int destinoColumna = 1;
    private static int count = 0;
    private static int mejorRutaCount = -1;
    private static String rutaActual = "";
    private static String mejorRuta = "";
    private static int[][] lab;
    private static int[][] labOriginal;

    public static void main(String[] args) {
        leerFichero();
        for (int j = 0; j < lab.length; j++) {
            if (lab[origenFila][j] == 1) {
                labOriginal[origenFila][j] = 0;
                lab[origenFila][j] = 0;
                algoritmo(lab, origenFila, j);
                lab = labOriginal;
                count = 0;
                rutaActual = "";
            }
        }
        System.out.println(mejorRuta);
    }

    /**
     * leer el fichero desde la ruta
     */
    public static void leerFichero() {
        int totalRow = 10;
        int totalColumn = 10;
        lab = new int[totalRow][totalColumn];
        labOriginal = new int[totalRow][totalColumn];
        String path = Main.class.getResource("laberinto").getPath();
        File file = new File(path);
        Scanner scanner = null;
        try {
            System.out.println("Buscando fichero en la ruta ->" + file.getAbsolutePath());
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                lab[row][i] = Character.getNumericValue(chars[i]);
                labOriginal[row][i] = Character.getNumericValue(chars[i]);
            }
        }
    }

    public static void algoritmo(int[][] lab, int i, int j) {
        int abajo = i + 1;
        int derecha = j + 1;
        int izquierda = j - 1;
        int arriba = i - 1;

        // busca abajo
        if (lab.length > abajo) {
            if (lab[abajo][j] == 1) {
                rutaActual = rutaActual + "(fila [" + abajo + "] col [" + j + "]), ";
                System.out.println("abajo -> fila [" + abajo + "] col [" + j + "]");
                if (!destinoEncontrado(abajo, j, count + 1)) {
                    lab[abajo][j] = 0; // marcar como explorado
                    count = count + 1;
                    algoritmo(lab, abajo, j);
                }
            }
        }
        // busca a la derecha
        if (lab[i].length > derecha) {
            if (lab[i][derecha] == 1) {
                rutaActual = rutaActual + "(fila [" + derecha + "] col [" + j + "]), ";
                System.out.println("derecha -> fila [" + i + "] col [" + derecha + "]");
                if (!destinoEncontrado(i, derecha, count + 1)) {
                    lab[i][derecha] = 0; // marcar como explorado
                    count = count + 1;
                    algoritmo(lab, i, derecha);
                }
            }
        }
        // busca a la izquierda
        if (izquierda > -1) {
            if (lab[i][izquierda] == 1) {
                rutaActual = rutaActual + "(fila [" + izquierda + "] col [" + j + "]), ";
                System.out.println("izquierda -> fila [" + i + "] col [" + izquierda + "]");
                if (!destinoEncontrado(i, izquierda, count + 1)) {
                    lab[i][izquierda] = 2; // marcar como explorado
                    count = count + 1;
                    algoritmo(lab, i, izquierda);
                }
            }
        }

        // busca arriba
        if (arriba > -1) {
            if (lab[arriba][j] == 1) {
                rutaActual = rutaActual + "(fila [" + arriba + "] col [" + j + "]), ";
                System.out.println("arriba -> fila [" + arriba + "] col [" + j + "]");
                if (!destinoEncontrado(arriba, j, count + 1)) {
                    lab[arriba][j] = 0; // marcar como explorado
                    count = count + 1;
                    algoritmo(lab, arriba, j);
                }
            }
        }
    }

    private static boolean destinoEncontrado(int i, int j, int count) {
        if (i == destinoFila && j == destinoColumna) {
            if (count < mejorRutaCount || mejorRutaCount == -1) {
                mejorRutaCount = count;
                mejorRuta = "El mejor camino es " + rutaActual + ". El coste ha sido de " + mejorRutaCount;
                rutaActual = "";
            }
            System.out.println("Camino encontrado, el coste de la ruta ha sido de " + count);
            return true;
        }
        return false;
    }
}
