
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Des {

    public static void main(String[] args) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            // SecretKey mykey = kg.generateKey();
            SecretKey mykey = kg.generateKey();

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, mykey);
            byte text[] = "hello your Great!".getBytes();

            System.out.println("Text in bytes : " + new String(text));
            byte enc[] = cipher.doFinal(text);
            System.err.println("encrypted msg = " + new String(enc));
            cipher.init(Cipher.DECRYPT_MODE, mykey);
            byte[] textdec = cipher.doFinal(enc);
            System.err.println("decrypted msg : " + new String(textdec));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
