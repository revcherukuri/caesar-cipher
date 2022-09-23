import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Caesar {
    public static void main (String [ ] args) {
        Scanner read = new Scanner  (System.in);
        System.out.println("Ciphertext:\n");

        String ciphertext = read.nextLine().toLowerCase();

        ArrayList<String> suggested = new ArrayList<>();
        for (int i = 1; i < 27; i++) {
            StringBuilder plaintext = decrypt(ciphertext, i);
            System.out.println(i + ". " + plaintext);
            if (plaintext.charAt(0) == 's' || plaintext.charAt(0) == 'p' || plaintext.charAt(0) == 'c' || plaintext.charAt(0) == 'a') {
                suggested.add(plaintext.toString());
            }
        }
        System.out.println("\nPerhaps one of these:\n");
        for (int i = 0; i < suggested.size(); i++) {
            System.out.println(suggested.get(i));
        }

    }

    public static StringBuilder decrypt (String ciphertext, int offset) {

        StringBuilder plaintext = new StringBuilder();
        char [] ciphertextArr = ciphertext.toCharArray();
        for (char c : ciphertextArr) {
            if (c != ' ') {
                int originalAlphaPosition = c - 'a';
                int newAlphaPosition = (originalAlphaPosition + offset) % 26;
                char newChar = (char) ('a' + newAlphaPosition);
                plaintext.append(newChar);
            }
            else {
                plaintext.append(c);
            }
        }
        return plaintext;
    }
}
