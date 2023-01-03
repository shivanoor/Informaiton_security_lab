import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public class Hash {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Algorithm:");// example sha1,md5
        String message = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance(message);
        System.out.println(md);
        System.out.println("Object Info:");
        System.out.println("Algorithm used is :" + md.getAlgorithm());
        System.out.println("Provider is :" + md.getProvider());
        byte[] output = md.digest();
        System.out.println(Base64.getEncoder().encodeToString(output));
    }
}
