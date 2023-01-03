
import java.util.Scanner;

public class ceaser_cipher {
    public static StringBuffer encrypt(String text, int shift) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {

                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string: ");
        String text = sc.nextLine();
        System.out.println("Enter shift: ");
        int shift = sc.nextInt();
        System.out.println("Input Text: " + text);
        System.out.println("Shift is: " + shift);
        System.out.println("Encrypted text is :" + encrypt(text, shift));
    }
}