import java.util.Scanner;

public class RSA {
    public static double gcd(double a, double h) {
        if (a == 0)
            return h;
        else
            return gcd(h % a, a);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double p, q;
        System.out.println("Enter p and q values:");
        p = sc.nextDouble();
        q = sc.nextDouble();
        double n = p * q;
        double phi = (p - 1) * (q - 1);
        double e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            else
                e++;
        }

        double d = 1;
        for (int i = 0; i <= 9; i++) {
            double x = 1 + (i * phi);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        System.out.println("d:" + d);
        System.out.println("Enter the Number to be encrypted:");
        double msg = sc.nextDouble();
        double encryptedMessage = Math.pow(msg, e) % n;
        System.out.println("encrypted message is :" + encryptedMessage);
        double decryptedMessage = Math.pow(encryptedMessage, e) % n;
        System.out.println("decrypted message is :" + decryptedMessage);
    }
}
