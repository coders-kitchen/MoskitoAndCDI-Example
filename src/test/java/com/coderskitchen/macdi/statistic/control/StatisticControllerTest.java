package com.coderskitchen.macdi.statistic.control;

import com.coderskitchen.macdi.entity.WordStatistics;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StatisticControllerTest {
    public static final String PROCESS_ID = "test";
    public static final String A_WORD = "a";
    StatisticController cut;
    @Before
    public void setUp() throws Exception {
        cut = new StatisticController();
        cut.setup();
    }

    @Test
    public void saveStatistic() throws Exception {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(A_WORD, 1);
        cut.saveStatistic(PROCESS_ID, A_WORD, map);

        HashMap<String, WordStatistics> result = cut.getStatisticsHashMap();
        assertThat(result.size(), is(1));
        WordStatistics test = result.get(PROCESS_ID);
        HashMap<String, Integer> statistics = test.getStatistics();
        assertThat(statistics.get(A_WORD), is(1));
        assertThat(test.getDocument(), is(A_WORD));
    }

    @Test
    public void findEmptyStatisticForNonExistingProcess() throws Exception {
        HashMap<String, Integer> map = cut.findStatisticForProcess(PROCESS_ID);
        assertThat(map.size(), is(0));
    }

    @Test
    public void findStatisticForExistingProcess() throws Exception {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(A_WORD, 1);
        WordStatistics ws = new WordStatistics();
        ws.setStatistics(map);
        cut.getStatisticsHashMap().put(PROCESS_ID, ws);

        HashMap<String, Integer> result = cut.findStatisticForProcess(PROCESS_ID);
        assertThat(result.size(), is(1));
        assertThat(result.get(A_WORD), is(1));
    }

    @Test
    public void findEmptyWordStatisticsForNonExistingProcess() throws Exception {
        WordStatistics result = cut.findWordStatisticsForProcess(PROCESS_ID);
        String resultProcessId = result.getProcessId();
        assertThat(resultProcessId, nullValue());
    }

    @Test
    public void findWordStatisticsForExistingProcess() {
        WordStatistics s = new WordStatistics();
        s.setProcessId(PROCESS_ID);
        cut.getStatisticsHashMap().put(PROCESS_ID, s);

        WordStatistics result = cut.findWordStatisticsForProcess(PROCESS_ID);
        String resultProcessId = result.getProcessId();
        assertThat(resultProcessId, is(PROCESS_ID));
    }
}
