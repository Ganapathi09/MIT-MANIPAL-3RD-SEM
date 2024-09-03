package program;

public class main1 {
    public static void main(String[] args) {
        String string = "This is a test string.";

        // Count the number of characters.
        int characters = string.length();

        // Count the number of words.
        int words = string.split(" ").length;

        // Count the number of lines.
        int lines = string.split("\n").length;

        // Count the number of vowels.
        int vowels = 0;
        for (char c : string.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            }
        }

        // Display the results.
        System.out.println("Characters: " + characters);
        System.out.println("Words: " + words);
        System.out.println("Lines: " + lines);
        System.out.println("Vowels: " + vowels);
    }
}
