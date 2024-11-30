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
        System.out.println(plugboard);
        return plugboard;
    }

    public static String plugboardEncrypt(String input, Map<Character, Character> plugboard) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char originalCharacter = input.charAt(i);
            char newCharacter = plugboard.getOrDefault(originalCharacter, originalCharacter);
            encryptedMessage.append(newCharacter);
        }

        String output = encryptedMessage.toString();
        return output;
    }

    public static void main(String[] args) {
        Map<Character, Character> plugboard = createPlugboard();
        System.out.println("Ange meddelande att kryptera:");
        Scanner inputMessageScanner = new Scanner(System.in);
        String inputMessage = "";
        try {
            inputMessage = inputMessageScanner.nextLine().toUpperCase();
        } finally {
            inputMessageScanner.close();
        }

        String outputMessage = plugboardEncrypt(inputMessage, plugboard);
        System.out.println("Input: " + inputMessage);
        System.out.println("Output: " + outputMessage);
    }
}