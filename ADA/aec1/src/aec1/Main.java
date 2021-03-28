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
        String result = "0";
        for (int i = 2; i <=1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                result = mA(i);
            }
            //System.out.println(i + " x " + (i - 1) + " = " + new BigInteger(result));
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("A1 seconds : " + formatTime(elapsedTime));
    }

    public static void a2() {
        long start = System.nanoTime();
        int result = 0;
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                result = mDV(i);
            }
            // System.out.println(i + " x " + (i - 1) + " = " + result);
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
    private static String mA(int n) {
        String strDigitsN1 = String.valueOf(n - 1);
        int totalCols = strDigitsN1.length() * 2;
        int rowIndex = 0;
        int [][] calc = new int[strDigitsN1.length()][strDigitsN1.length() * 2];
        for (int i = strDigitsN1.length() - 1; i >= 0; i--) {
           int digit =  Character.getNumericValue(strDigitsN1.charAt(i));
           String subResult = String.valueOf(n * digit);
           int indexSub = subResult.length() -1;
            for (int j = totalCols - 1; j >= 0; j--) {
                if (indexSub >= 0) {
                    calc[rowIndex][j] = Character.getNumericValue(subResult.charAt(indexSub));
                    indexSub--;
                }
            }
            rowIndex ++;
            totalCols --;
        }
        String result = "";
        String restStr = "0";
        for (int j = calc[0].length-1; j >= 0; j--) {
            int colResult = 0;
            int rest = Integer.parseInt(restStr);
            // sumar columna
            for (int i = 0; i < strDigitsN1.length(); i++) {
                colResult = calc[i][j] + colResult + rest;
                rest = 0;
            }
            // sacar el resto de la suma
            // ejemplo de una suma de 12
            // se coge el 2 y el resto 1 se suma en la siguiente
            char[] array = String.valueOf(colResult).toCharArray();
            result = array[array.length - 1] + result;
            restStr = "0";
            if (array.length == 2) { // resto
                restStr += array[0];
            }
        }
        return result;
    }

    /**
     * divide y vencerás
     *
     * @param n
     * @return
     */
    private static int mDV(int n) {
        if (n == 0) {
            return 0;
        }
        String strDigitsN = String.valueOf(n);
        String strDigitsN1 = String.valueOf(n - 1);

        String[] arrayN = new String[strDigitsN.length()];
        String[] arrayN1 = new String[strDigitsN1.length()];
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
        // set values to variables "a" and "b"
        if (arrayN.length == 1) {
            a = 0;
            b = Integer.valueOf(arrayN[0]);
        } else if (arrayN.length == 2) {
            a = 0;
            b = Integer.parseInt(arrayN[0] + arrayN[1]);
        } else if (arrayN.length == 3) {
            a = Integer.valueOf(arrayN[0]);
            b = Integer.parseInt(arrayN[1] + arrayN[2]);
        } else if (arrayN.length == 4) {
            a = Integer.parseInt(arrayN[0] + arrayN[1]);
            b = Integer.parseInt(arrayN[2] + arrayN[3]);
        } else if (arrayN.length == 5) {
            a = Integer.parseInt(arrayN[0] + arrayN[1]);
            b = Integer.parseInt(arrayN[2] + arrayN[3]+ arrayN[4]);
        } else if (arrayN.length == 6) {
            a = Integer.parseInt(arrayN[0] + arrayN[1] + arrayN[2]);
            b = Integer.parseInt(arrayN[3] + arrayN[4] + arrayN[5]);
        } else if (arrayN.length == 7) {
            a = Integer.parseInt(arrayN[0] + arrayN[1] + arrayN[2]);
            b = Integer.parseInt(arrayN[3] + arrayN[4] + arrayN[5] + arrayN[6]);
        }
        // set values to variables "c" and "d"
        if (arrayN1.length == 1) {
            c = 0;
            d = Integer.valueOf(arrayN1[0]);
        } else if (arrayN1.length == 2) {
            c = 0;
            d = Integer.parseInt(arrayN1[0] + arrayN1[1]);
        } else if (arrayN1.length == 3) {
            c = Integer.valueOf(arrayN1[0]);
            d = Integer.parseInt(arrayN1[1] + arrayN1[2]);
        } else if (arrayN1.length == 4) {
            c = Integer.parseInt(arrayN1[0] + arrayN1[1]);
            d = Integer.parseInt(arrayN1[2] + arrayN1[3]);
        } else if (arrayN1.length == 5) {
            c = Integer.parseInt(arrayN1[0] + arrayN1[1]);
            d = Integer.parseInt(arrayN1[2] + arrayN1[3] + arrayN1[4]);
        } else if (arrayN1.length == 6) {
            c = Integer.parseInt(arrayN1[0] + arrayN1[1] + arrayN1[2]);
            d = Integer.parseInt(arrayN1[3] + arrayN1[4] + arrayN1[5]);
        } else if (arrayN1.length == 7) {
            c = Integer.parseInt(arrayN1[0] + arrayN1[1] + arrayN1[2]);
            d = Integer.parseInt(arrayN1[3] + arrayN1[4] + arrayN1[5] + arrayN1[6]);
        }
        // calculate axc axd bxc bxd
        int ac = a * c;
        int ad = a * d;
        int bc = b * c;
        int bd = b * d;
        // final result
        // (axc)x10⁴+(axd+bxc)x10²+(bxd)
        return (int) ((int) (ac * Math.pow(10, 4)) + (ad + bc) * Math.pow(10, 2) + (bd));
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
