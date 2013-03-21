package com.coderskitchen.macdi.statistic.control;

import com.coderskitchen.macdi.entity.WordStatistics;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.HashMap;

/**
 * This class handles the CRUD operations for the WordStatistics
 */
@Singleton
public class StatisticController {

    private HashMap<String, WordStatistics> statisticsHashMap;

    @PostConstruct
    void setup() {
        statisticsHashMap = new HashMap<String, WordStatistics>();
    }

    public void saveStatistic(String processId, String document, HashMap<String, Integer> statistics) {
        WordStatistics stat = new WordStatistics();
        stat.setStatistics(statistics);
        stat.setProcessId(processId);
        stat.setDocument(document);
        statisticsHashMap.put(processId, stat);
    }

    public HashMap<String, Integer> findStatisticForProcess(String processId) {
        return findWordStatisticsForProcess(processId).getStatistics();
    }

    public WordStatistics findWordStatisticsForProcess(String processId) {
        WordStatistics wordStatistics = statisticsHashMap.get(processId);
        if(wordStatistics == null)
            wordStatistics = new WordStatistics();
        return wordStatistics;
    }

    HashMap<String, WordStatistics> getStatisticsHashMap() {
        return statisticsHashMap;
    }

}
