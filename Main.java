import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Character, Character> createPlugboard() {
        Map<Character, Character> plugboard = new HashMap<>();
        plugboard.put('A', 'B');
        plugboard.put('C', 'D');
        plugboard.put('E', 'F');
        plugboard.put('G', 'H');
        plugboard.put('I', 'J');
        plugboard.put('K', 'L');

        for (Map.Entry<Character, Character> entry : new HashMap<>(plugboard).entrySet()) {
            char key = entry.getKey();
            char value = entry.getValue();
            plugboard.put(value, key);
        }

        return plugboard;
    }

    public static String plugboardEncrypt(String message, Map<Character, Character> plugboard) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char originalCharacter = message.charAt(i);
            char newCharacter = plugboard.getOrDefault(originalCharacter, originalCharacter);
            encryptedMessage.append(newCharacter);
        }

        return encryptedMessage.toString();
    }

    public static void main(String[] args) {
        Map<Character, Character> plugboard = createPlugboard();
        System.out.println("Ange meddelande att kryptera:");
        Scanner scanner = new Scanner(System.in);
        String inputMessage = "";
        try {
            inputMessage = scanner.nextLine().toUpperCase();
        } finally {
            scanner.close();
        }

        String outputMessage = plugboardEncrypt(inputMessage, plugboard);
        System.out.println("Okrypterat meddelande: " + inputMessage);
        System.out.println("Krypterat meddelande: " + outputMessage);
    }
}