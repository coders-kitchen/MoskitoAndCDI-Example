package com.coderskitchen.macdi.statistic;

import com.coderskitchen.macdi.entity.WordStatistics;
import com.coderskitchen.macdi.statistic.control.StatisticController;
import com.coderskitchen.macdi.statistic.control.WordStatisticProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DocumentStatisticBoundaryTest {
    public static final String TESTDOCUMENT = "TESTDOCUMENT";
    public static final String PROCESS_ID = "TEST";
    @Mock
    WordStatisticProcessor wspMock;

    @Mock
    StatisticController scMock;

    DocumentStatisticBoundary cut;
    private HashMap<String,Integer> wsStatistics;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        cut = new DocumentStatisticBoundary();
        cut.wsd = wspMock;
        cut.sp = scMock;

        WordStatistics ws = new WordStatistics();
        ws.setProcessId(PROCESS_ID);
        wsStatistics = ws.getStatistics();
        wsStatistics.put("A", 1);
        when(scMock.findWordStatisticsForProcess(PROCESS_ID)).thenReturn(ws);
        when(scMock.findStatisticForProcess(PROCESS_ID)).thenReturn(wsStatistics);

        when(wspMock.deriveStatisticFrom(TESTDOCUMENT)).thenReturn(wsStatistics);
    }

    @Test
    public void getCountingForExistingWord() throws Exception {
        Integer counting = cut.getCountingForWord(PROCESS_ID, "A");
        assertThat(counting, is(1));
    }

    @Test
    public void getCountingForNonExistingWord() {
        Integer counting = cut.getCountingForWord(PROCESS_ID, "B");
        assertThat(counting, is(0));

    }

    @Test
    public void processDocumentAndCreateStatistic() throws Exception {
        HashMap<String, Integer> statistics = cut.processDocumentAndCreateStatistic(TESTDOCUMENT);
        assertThat(statistics.get("A"), is(1));
    }

    @Test
    public void createAndPersistStatistic() throws Exception {
        cut.createAndPersistStatistic(PROCESS_ID, TESTDOCUMENT);
        verify(scMock, times(1)).saveStatistic(PROCESS_ID, TESTDOCUMENT,wsStatistics);
    }
}
