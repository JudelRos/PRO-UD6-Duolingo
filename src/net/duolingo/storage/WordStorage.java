package net.duolingo.storage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordStorage {
    Scanner scanner = new Scanner(System.in);
    Map<String, Set<String>> wordContainer = new HashMap<>();

    public void addWord(lastWord){
        String initial = lastWord.substring(0, 1).toLowerCase();
        Set<String> wordsStartingWithInitial = wordContainer.get(initial);
        if (wordsStartingWithInitial == null) {
            wordsStartingWithInitial = new HashSet<>();
            wordContainer.put(initial, wordsStartingWithInitial);
        }

        wordsStartingWithInitial.add(lastWord);
    }
}
