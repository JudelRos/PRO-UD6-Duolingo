package net.duolingo.storage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordStorage {
    Scanner scanner = new Scanner(System.in);
    Map<String, Set<String>> wordContainer = new HashMap<>();

    public void addWord(String lastWord) {
        String initial = lastWord.substring(0, 1).toLowerCase();
        String wordToInsert = lastWord.trim().toLowerCase();
        Set<String> wordsStartingWithInitial = wordContainer.get(initial);
        if (wordsStartingWithInitial == null) {
            wordsStartingWithInitial = new HashSet<>();
            wordContainer.put(initial, wordsStartingWithInitial);
        } else {
            wordsStartingWithInitial.add(wordToInsert);
        }
    }

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

    public void showInitials() {
        if (wordContainer.isEmpty()) {
            System.out.println("There are still no initials in the dictionary");
        } else {
            for (int i = 0; i < wordContainer.size(); i++) {
                System.out.println("The initial " + wordContainer.get(i) + " exists.");
            }
        }
    }

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

    public Map<String, Set<String>> getWordContainer() {
        return wordContainer;
    }

    public void setWordContainer(Map<String, Set<String>> wordContainer) {
        this.wordContainer = wordContainer;
    }
}