import java.util.Scanner;

public class Detyre_Shtepie4 {

    public static boolean eshteValide(long numri) {

        int total = sum2(numri) + sum1(numri);


        if ((total % 10 == 0) && (kodi(numri, 1) == true) && (gjatesia(numri)>=13 ) && (gjatesia(numri)<=16 )) {
            return true;
        } else {
            return false;
        }
    }

    public static int shifra(int numri) {

        if (numri <= 9) {
            return numri;
        } else {
            int numriPare = numri % 10;
            int numriDyte = (int) (numri / 10);

            return numriPare + numriDyte;
        }
    }
    public static int sum1(long numri) {
        int result = 0;

        while (numri > 0) {
            result += (int) (numri % 10);
            numri = numri / 100;
        }

        return result;
    }

    public static int sum2(long numri) {

        int result = 0;
        long temp = 0;

        while (numri > 0) {
            temp = numri % 100;
            result += shifra((int) (temp / 10) * 2);
            numri = numri / 100;
        }

        return result;
    }

    public static boolean kodi(long numri, int d) {

        if ((gjejKodi(numri, d) == 4)
                || (gjejKodi(numri, d) == 5)
                || (gjejKodi(numri, d) == 3)) {

            if (gjejKodi(numri, d) == 3) {
                System.out.println("\nVisa Card ");
            } else if (gjejKodi(numri, d) == 5) {
                System.out.println("\nMaster Card ");
            } else if (gjejKodi(numri, d) == 3) {
                System.out.println("\nAmerican Express Card ");
            }

            return true;

        } else {

            return false;

        }
    }

    public static int gjatesia(long d) {

        int count = 0;

        while (d > 0) {
            d = d / 10;

            count++;
        }

        return count;

    }

    public static long gjejKodi(long numri, int k) {

        if (gjatesia(numri) < k) {
            return numri;
        } else {

            int size = (int) gjatesia(numri);

            for (int i = 0; i < (size - k); i++) {
                numri = numri / 10;
            }

            return numri;

        }

    }
    //test

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Vendos numrin e kartes se kreditit: ");

        long karta = input.nextLong();


        if (eshteValide(karta) == true) {
            System.out.println("Kodi " + karta + " eshte i sakte.");
        } else {
            System.out.println("Kodi " + karta + " eshte i pasakte ");
        }

    }
}
