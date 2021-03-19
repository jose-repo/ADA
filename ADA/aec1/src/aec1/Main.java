package aec1;

public class Main {

    public static void main(String[] args) {
        System.out.println("This will be printed");
    }

    public static void a1() {
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                mA(i);
            }
        }
    }

    public static void a2() {
        for (int i = 2; i <= 1000000; i++) {
            for (int e = 1; e <= 100; e++) {
                mDV(i);
            }
        }
    }

    /**
     * multiplicación americana
     *
     * @param n
     * @return
     */
    private static int mA(int n) {
        return  n * (n-1);
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
        int[] arrayN = new int[strDigitsN.length()];
        for (int i = 0; i < strDigitsN.length(); i++) {
            arrayN[i] = strDigitsN.charAt(i);
        }

        String strDigitsN1 = String.valueOf(n-1);
        int[] arrayN1 = new int[strDigitsN.length()];
        for (int i = 0; i < strDigitsN.length(); i++) {
            arrayN1[i] = strDigitsN.charAt(i);
        }
        return 0;
    }


}
