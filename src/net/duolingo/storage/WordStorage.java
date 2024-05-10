package net.duolingo.storage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The `WordStorage` class in Java provides methods to add, delete, check
 * existence, and display words
 * stored in a map based on their initial letters.
 */
public class WordStorage {
    Scanner scanner = new Scanner(System.in);
    Map<String, Set<String>> wordContainer = new HashMap<>();

    /**
     * The `addWord` function adds a word to a collection based on its initial
     * letter.
     * 
     * @param lastWord The `lastWord` parameter is a `String` representing the last
     *                 word that you want
     *                 to add to a data structure.
     */
    public void addWord(String lastWord) {
        String initial = lastWord.substring(0, 1).toLowerCase();
        String wordToInsert = lastWord.trim().toLowerCase();

        Set<String> wordsStartingWithInitial = wordContainer.get(initial);

        if (wordsStartingWithInitial == null) {
            wordsStartingWithInitial = new HashSet<>();
            wordContainer.put(initial, wordsStartingWithInitial);
        }

        wordsStartingWithInitial.add(wordToInsert);
    }

    /**
     * The `deleteWord` function removes a specified word from a collection,
     * checking if it exists
     * based on the initial letter of the word.
     * 
     * @param wordToDelete The `wordToDelete` parameter in the `deleteWord` method
     *                     is the word that you
     *                     want to delete from the word container. This method first
     *                     converts the word to lowercase, trims
     *                     any leading or trailing spaces, and then checks if the
     *                     word exists in the word container. If the
     *                     word is found
     */
    public void deleteWord(String wordToDelete) {
        String deletedWord = wordToDelete.toLowerCase().trim();
        String deletedWordInitial = deletedWord.substring(0, 1);
        Set<String> wordsStartingWithInitial = wordContainer.get(deletedWordInitial);
        if (wordsStartingWithInitial != null && wordsStartingWithInitial.contains(deletedWord)) {
            wordsStartingWithInitial.remove(deletedWord);
            if (wordsStartingWithInitial.isEmpty()) {
                wordContainer.remove(deletedWordInitial);
            }
            System.out.println("The word " + wordToDelete + " has been deleted.");
        } else {
            System.out.println("The selected word doesn't exist");
        }
    }

    /**
     * The `wordExists` function checks if a given word exists in a collection of
     * sets of words,
     * ignoring case and leading/trailing spaces.
     * 
     * @param wordToCheck The `wordToCheck` parameter is a `String` representing the
     *                    word that needs to
     *                    be checked for existence in the `wordContainer`.
     */
    public void wordExists(String wordToCheck) {
        String checkedWord = wordToCheck.toLowerCase().trim();
        boolean exists = false;
        for (Set<String> wordSet : wordContainer.values()) {
            if (wordSet.contains(checkedWord)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("The word " + wordToCheck + " exists.");
        } else {
            System.out.println("The selected word doesn't exist.");
        }
    }

    /**
     * The `showInitials` function checks if the wordContainer is empty and displays
     * a message
     * accordingly, or prints out the existing initials in the dictionary.
     */
    public void showInitials() {
        if (wordContainer.isEmpty()) {
            System.out.println("There are still no initials in the dictionary");
        } else {
            for (String initial : wordContainer.keySet()) {
                System.out.println("The initial " + initial + " exists.");
            }
        }
    }

    /**
     * This Java function filters and displays words stored in a map based on a
     * specified initial
     * letter.
     * 
     * @param initialChosen The `initialChosen` parameter in the
     *                      `showWordsByInitial` method is a
     *                      String representing the initial letter for which you
     *                      want to retrieve words from the
     *                      `wordContainer`. The method converts the `initialChosen`
     *                      String to lowercase and then checks if
     *                      the `wordContainer` contains any words
     */
    public void showWordsByInitial(String initialChosen) {
        String validInitialChosen = initialChosen.toLowerCase();
        if (wordContainer.containsKey(validInitialChosen)) {
            Map<String, Set<String>> filteredWordContainer = wordContainer.entrySet().stream()
                    .filter(x -> x.getKey().equals(validInitialChosen))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            for (String key : filteredWordContainer.keySet()) {
                Set<String> value = filteredWordContainer.get(key);
                System.out.println(value);
            }
        } else {
            System.out.println("There are no words saved by that initial.");
        }
    }

    /**
     * The function `getWordContainer` returns a map where each key is a string and
     * its corresponding
     * value is a set of strings.
     * 
     * @return A Map<String, Set<String>> named wordContainer is being returned.
     */
    public Map<String, Set<String>> getWordContainer() {
        return wordContainer;
    }

    /**
     * The function sets a map of strings to sets of strings in a Java class.
     * 
     * @param wordContainer A map where the keys are strings and the values are sets
     *                      of strings.
     */
    public void setWordContainer(Map<String, Set<String>> wordContainer) {
        this.wordContainer = wordContainer;
    }
}
