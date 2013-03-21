package com.coderskitchen.macdi.statistic.control;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordStatisticProcessorTest {

    WordStatisticProcessor cut = new WordStatisticProcessor();

    @Test
    public void deriveStatisticsForEmptyDocument() {
        deriveStatisticsAndAssertSize("", 0);
    }

    @Test
    public void deriveStatisticsForNullDocument() {
        deriveStatisticsAndAssertSize(null, 0);
    }

    @Test
    public void deriveStatisticsForOneLetter() {
        HashMap<String, Integer> result = deriveStatisticsAndAssertSize("A", 1);
        assertThat(result.get("a"), is(1));
    }

    @Test
    public void deriveStatisticsForTwoSingleLetters() {
        HashMap<String, Integer> result = deriveStatisticsAndAssertSize("A B", 2);
        assertThatCountIs(result, 1);
    }

    @Test
    public void deriveStatisticsForTwoMultiOccurrenceLetters() {
        HashMap<String, Integer> result = deriveStatisticsAndAssertSize("A A B B C C", 3);
        assertThatCountIs(result, 2);
    }

    @Test
    public void deriveStatisticsForMixedDocument() {
        HashMap<String, Integer> result = deriveStatisticsAndAssertSize("The lazy dog hunts the quick brown fox.", 7);
        for(String key : result.keySet()) {
            int count = 1;
            if(key.equalsIgnoreCase("the"))
                count = 2;
            assertThat(key, result.get(key), is(count));
        }
    }

    private void assertThatCountIs(HashMap<String, Integer> result, int value) {
        for (String key : result.keySet()) {
            assertThat(key, result.get(key), is(value));
        }
    }

    private HashMap<String, Integer> deriveStatisticsAndAssertSize(String document, int expectedSize) {
        HashMap<String, Integer> result = cut.deriveStatisticFrom(document);
        assertThat(result.size(), is(expectedSize));
        return result;
    }
}
