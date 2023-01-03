import java.security.*;
import java.util.*;
import java.util.Base64.*;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); // RSA
        kg.initialize(1024);// intialize size of key
        KeyPair kp = kg.genKeyPair();
        PrivateKey prikey = kp.getPrivate();
        PublicKey pubkey = kp.getPublic();
        String message = "This is the message to be signed";
        Signature sg = Signature.getInstance("MD5WithRSA"); // SHA256WithRSA
        sg.initSign(prikey);
        sg.update(message.getBytes());
        byte[] signedMessage = sg.sign();
        String encodeMessage = Base64.getEncoder().encodeToString(signedMessage);
        System.out.println("Signed Message is : " + encodeMessage);
        sg.initVerify(pubkey);
        sg.update(message.getBytes());
        boolean verified = sg.verify(signedMessage);
        System.out.println("Verification:" + verified);
        
        
        // To show Verification Failed case
        KeyPairGenerator kg2 = KeyPairGenerator.getInstance("RSA");
        kg2.initialize(1024);
        KeyPair kp2 = kg2.genKeyPair();
        PublicKey pubkey2 = kp2.getPublic();
        sg.initVerify(pubkey2);
        sg.update(message.getBytes());
        boolean verified2 = sg.verify(signedMessage);
        System.out.println("Verification:" + verified2);

    }
}
