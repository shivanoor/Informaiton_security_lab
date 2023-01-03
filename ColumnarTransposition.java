import java.util.Scanner;

public class ColumnarTransposition {
    public static int[] getOrder(String key) {
        // Create an array with the indices of the key characters
        int[] order = new int[key.length()];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }

        // Sort the array based on the key
        for (int i = 0; i < order.length; i++) {
            for (int j = i; j < order.length - 1; j++) {
                if (key.charAt(j + 1) > key.charAt(j)) {
                    int temp = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp;
                }
            }
        }
        return order;
    }

    public static String encrypt(String message, String key) {
        // Create a matrix with the message
        int numColumns = key.length();
        int numRows = message.length() / numColumns;
        if (message.length() % numColumns > 0) {
            numRows++;
        }
        char[][] matrix = new char[numRows][numColumns];
        for (int i = 0, k = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++, k++) {
                if (k < message.length()) {
                    matrix[i][j] = message.charAt(k);
                } else {
                    matrix[i][j] = '#';
                }
            }
        }

        // Sort the columns according to the key
        int[] order = getOrder(key);
        char[][] sortedMatrix = new char[numRows][numColumns];
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                sortedMatrix[j][order[i]] = matrix[j][i];
            }
        }

        // Flatten the matrix into a single string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                sb.append(sortedMatrix[i][j]);
            }
        }

        return sb.toString();
    }

    public static String decrypt(String message, String key) {
        // Create a matrix with the message
        int numColumns = key.length();
        int numRows = message.length() / numColumns;
        char[][] matrix = new char[numRows][numColumns];
        for (int i = 0, k = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++, k++) {
                matrix[i][j] = message.charAt(k);
            }
        }

        // Reorder the columns according to the key
        int[] order = getOrder(key);
        char[][] sortedMatrix = new char[numRows][numColumns];
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                sortedMatrix[j][i] = matrix[j][order[i]];
            }
        }

        // Flatten the matrix into a single string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                sb.append(sortedMatrix[i][j]);
            }

        }

        // Remove padding characters
        return sb.toString().replaceAll("#", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        System.out.print("Enter the key: ");
        String key = sc.nextLine();

        // Encrypt the message
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}