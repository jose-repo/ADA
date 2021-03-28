package aec1;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");
        a1();
        a2();
        System.out.println("end");
    }

    public static void a1() {
        long start = System.nanoTime();
        long result = 0;
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                result = mA(i);
            }
            if (i == 55555) {
                System.out.println(i + " x " + (i - 1) + " = " + result);
            }
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("A1 seconds : " + formatTime(elapsedTime));
    }

    public static void a2() {
        long start = System.nanoTime();
        long result = 0;
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                result = mDV(i);
            }
            if (i == 55555) {
                System.out.println(i + " x " + (i - 1) + " = " + result);
            }
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("A2 seconds: " + formatTime(elapsedTime));
    }

    /**
     * multiplicación americana
     *
     * @param n
     * @return
     */
    private static long mA(int n) {
        String strMultiplicand = String.valueOf(n - 1);
        long result = 0;
        long currentValue = 0;
        long pow = 0;
        int index = 0;
        // se recorren todos los dígitos del multiplicador
        for (int i = strMultiplicand.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(strMultiplicand.charAt(i));
            currentValue = (n * digit);
            if (index > 0) {
                // se colocan los ceros a la derecha
                // por cada posición del multiplicador, se añade un cero
                pow = currentValue * Integer.valueOf((int) Math.pow(10, index));
            }
            if (pow == 0) {
                pow = currentValue;
            }
            // se suma al resultado obtenido hasta el momento
            result += pow;
            index++;
        }
        return result;
    }

    /**
     * divide y vencerás
     *
     * @param n
     * @return
     */
    private static long mDV(int n) {
        if (n == 0) {
            return 0;
        }
        // para dividir los valores se utilizan
        // string y array de string
        String strDigitsN = String.valueOf(n);
        String strDigitsN1 = String.valueOf(n - 1);

        String[] arrayN = new String[strDigitsN.length()];
        String[] arrayN1 = new String[strDigitsN1.length()];
        // se pasa el string al array
        for (int i = 0; i < strDigitsN.length(); i++) {
            arrayN[i] = String.valueOf(strDigitsN.charAt(i));
        }
        for (int i = 0; i < strDigitsN1.length(); i++) {
            arrayN1[i] = String.valueOf(strDigitsN1.charAt(i));
        }

        // init variable
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        // INICIALIZAR BLOQUE A y B -----------------------------
        String concatenateZero = "";
        // si el número es impar se rellena con 0 por la izquierda
        if (arrayN.length %2 != 0) {
            concatenateZero = "0";
        }
        int half = arrayN.length / 2;
        String aStr = concatenateZero;
        String bStr = "";
        // primera mitad del número
        // ejemplo para 1122 coge el 11
        for (int i = 0; i < half; i++) {
            aStr += arrayN[i];
        }
        // segunda mitad del número
        // ejemplo para 1122 coge el 22
        for (int i = half; i < arrayN.length; i++) {
            bStr += arrayN[i];
        }
        if (bStr.isEmpty()) {
            bStr = "0";
        }
        if (aStr.isEmpty()) {
            aStr = "0";
        }
        // inicializa la variable a y b
        a = Integer.valueOf(aStr);
        b = Integer.valueOf(bStr);

        // INICIALIZAR BLOQUE B y C -----------------------------
        concatenateZero = "";
        // si el número es impar se rellena con 0 por la izquierda
        if (arrayN1.length %2 != 0) {
            concatenateZero = "0";
        }
        half = arrayN1.length / 2;
        String cStr = concatenateZero;
        String dStr = "";
        for (int i = 0; i < half; i++) {
            cStr += arrayN1[i];
        }
        for (int i = half; i < arrayN1.length; i++) {
            dStr += arrayN1[i];
        }
        if (cStr.isEmpty()) {
            cStr = "0";
        }
        if (dStr.isEmpty()) {
            dStr = "0";
        }
        // inicializar c y d
        c = Integer.valueOf(cStr);
        d = Integer.valueOf(dStr);
        // calcular axc axd bxc bxd
        int ac = a * c;
        int ad = a * d;
        int bc = b * c;
        int bd = b * d;
        // final result
        // (axc)x10⁴+(axd+bxc)x10²+(bxd)
        int exp = strDigitsN1.length();
        int exp2 = exp / 2;
        // si el número es impar se suma uno a cada exponente
        if (exp %2 != 0) {
            exp += 1;
            exp2 += 1;
        }

        long acR = (long) (ac * Math.pow(10, exp));
        long adR = (long) ((ad) * Math.pow(10, exp2));
        long bcR = (long) ((bc) * Math.pow(10, exp2));
        return (acR + adR + bcR + (bd));
    }

    /**
     * returns a formatted long time (nanoseconds to seconds)
     *
     * @param time
     * @return
     */
    private static String formatTime(long time) {
        return String.valueOf((double) time / 1_000_000_000.0);
    }

}
