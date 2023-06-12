import java.util.*;

public class AnagramCounter {
    public static void main(String[] args) {
        // collection of documents
        String[] documents = {"The quick brown fox", "jumps over the lazy dog", "The quick brown fox"};

        // create a HashMap to store anagram counts
        Map<String, Integer> anagramCounts = new HashMap<>();

        // iterate over each document
        for (String document : documents) {
            // split the document into words
            String[] words = document.toLowerCase().split(" ");

            // iterate over each word
            for (String word : words) {
                // convert the word to a char array and sort it
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = new String(chars);

                // increment the anagram count in the HashMap
                int count = anagramCounts.getOrDefault(sortedWord, 0);
                anagramCounts.put(sortedWord, count + 1);
            }
        }

        // print the anagram counts
        for (Map.Entry<String, Integer> entry : anagramCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Anagram " + entry.getKey() + " occurs " + entry.getValue() + " times.");
            }
        }
    }
}
