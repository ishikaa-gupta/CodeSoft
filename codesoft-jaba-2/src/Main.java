//Task 2- Word Counter

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text:");
        String inputText = scanner.nextLine();

        String[] words = inputText.split("[\\s\\p{Punct}]+");

        int wordCount = words.length;

        System.out.println("Total number of words: " + wordCount);

        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "a", "an", "and", "the", "in", "on", "of", "to", "with"
        ));

        Set<String> uniqueWords = new HashSet<>();

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                uniqueWords.add(word);

                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Number of unique words: " + uniqueWords.size());

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}