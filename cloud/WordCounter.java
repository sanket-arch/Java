import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // collection of documents
        String[] documents = {"The quick brown fox", "jumps over the lazy dog", "The quick brown fox"};

        // create a HashMap to store word counts
        Map<Integer, Map<String, Integer>> wordCounts = new HashMap<>();

        // iterate over each document
        for (String document : documents) {
            // split the document into words
            String[] words = document.toLowerCase().split(" ");

            // iterate over each word
            for (String word : words) {
                // get the length of the word
                int length = word.length();

                // if the length is not already in the outer HashMap, add it with a new inner HashMap
                if (!wordCounts.containsKey(length)) {
                    wordCounts.put(length, new HashMap<>());
                }

                // increment the word count in the inner HashMap
                Map<String, Integer> innerMap = wordCounts.get(length);
                int count = innerMap.getOrDefault(word, 0);
                innerMap.put(word, count + 1);
            }
        }

        // print the word counts
        for (Map.Entry<Integer, Map<String, Integer>> entry : wordCounts.entrySet()) {
            System.out.println("Words with " + entry.getKey() + " letters:");
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                System.out.println(innerEntry.getKey() + ": " + innerEntry.getValue());
            }
        }
    }
}
