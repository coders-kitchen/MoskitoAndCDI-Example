package com.coderskitchen.macdi.statistic;

import com.coderskitchen.macdi.entity.WordStatistics;
import com.coderskitchen.macdi.statistic.control.StatisticController;
import com.coderskitchen.macdi.statistic.control.WordStatisticProcessor;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;

@Stateless
public class DocumentStatisticBoundary {

    @Inject
    WordStatisticProcessor wsd;
    @Inject
    StatisticController sp;

    public Integer getCountingForWord(String processId, String word) {
        HashMap<String, Integer> wordStatistic = sp.findStatisticForProcess(processId);
        Integer count = wordStatistic.get(word);
        return count == null ? 0 : count;
    }

    public HashMap<String, Integer> processDocumentAndCreateStatistic(String document) {
        HashMap<String, Integer> statistics = wsd.deriveStatisticFrom(document);
        return statistics;
    }

    @Asynchronous
    public void createAndPersistStatistic(String processId, String document) {
        HashMap<String, Integer> statistics = processDocumentAndCreateStatistic(document);
        sp.saveStatistic(processId, document, statistics);
    }

	public WordStatistics getWordStatistics(final String processId) {
		return  sp.findWordStatisticsForProcess(processId);
	}
}
