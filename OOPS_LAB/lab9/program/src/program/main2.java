package program;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String wordToReplace = scanner.nextLine();

        // Repeat the characters of the word to replace
        String replacement = wordToReplace.replaceAll(".", "$0$0");

        // Replace all occurrences of the word with repeating characters
        String modifiedSentence = sentence.replaceAll(wordToReplace, replacement);

        System.out.println("Modified Sentence: " + modifiedSentence);

        scanner.close();
    }
}
