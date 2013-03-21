package com.coderskitchen.macdi.statistic.control;

import java.util.HashMap;

public class WordStatisticProcessor {
    public HashMap<String, Integer> deriveStatisticFrom(String document) {
        HashMap<String, Integer> statistic = new HashMap<String, Integer>();
        if (isDocumentNotEmpty(document)) {
            splitDocumentAndAddWords(document, statistic);
        }
        return statistic;
    }

    private void splitDocumentAndAddWords(String document, HashMap<String, Integer> statistic) {
        String[] words = document.split(" ");
        for (String word : words) {
            incrementWordCount(statistic, word.toLowerCase());
        }
    }

    private void incrementWordCount(HashMap<String, Integer> statistic, String word) {
        if(!statistic.containsKey(word))
            statistic.put(word, 0);
        int incremented = statistic.get(word) + 1;
        statistic.put(word, incremented);
    }

    private boolean isDocumentNotEmpty(String document) {
        return document != null && !document.isEmpty();
    }
}
