
public class DiffieHellman {
    private static long power(long a, long b, long P) {
        if (b == 1)
            return a;
        else
            return (((long) Math.pow(a, b)) % P);
    }

    public static void main(String[] args) {
        long P, G, x, y, ka, kb;
        P = 29;
        System.out.println("value of P is:  " + P);
        G = 15;
        System.out.println("value of G is: " + G);
        long a = 4;
        long b = 3;
        x = power(G, a, P);
        // System.err.println("secret key of person1 : " + x);
        y = power(G, b, P);
        // System.err.println("Secret key of person2 : " + y);
        ka = power(y, a, P);
        kb = power(x, b, P);
        System.err.println("Shared  key for person1: " + ka);
        System.err.println("Shared key for person2: " + kb);

    }
}
