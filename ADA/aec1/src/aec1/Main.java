package aec1;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");
        a1();
        a2();
        System.out.println("end");
    }

    public static void a1() {
        long start = System.nanoTime();
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                int result = mA(i);
            }
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("A1 seconds : " + formatTime(elapsedTime));
    }

    public static void a2() {
        long start = System.nanoTime();
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                int result = mDV(i);
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
    private static int mA(int n) {
        return n * (n - 1);
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

        // split n to array
        String[] arrayN = strDigitsN.split("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)");
        // split n-1 to array
        String[] arrayN1 = strDigitsN1.split("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)");
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
        } else if (arrayN.length == 6) {
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
            c = Integer.parseInt(arrayN1[0] + arrayN[1]);
            d = Integer.parseInt(arrayN1[2] + arrayN1[3]);
        } else if (arrayN1.length == 5) {
            c = Integer.parseInt(arrayN1[0] + arrayN[1]);
            d = Integer.parseInt(arrayN1[2] + arrayN1[3] + arrayN1[4]);
        } else if (arrayN1.length == 6) {
            c = Integer.parseInt(arrayN1[0] + arrayN[1] + arrayN1[2]);
            d = Integer.parseInt(arrayN1[3] + arrayN1[4] + arrayN1[5]);
        } else if (arrayN1.length == 7) {
            c = Integer.parseInt(arrayN1[0] + arrayN[1] + arrayN1[2]);
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
