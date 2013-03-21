package com.coderskitchen.macdi.process;

import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class ProcessBoundaryTest {

    @Test
    public void createNewProcessId() {
        ProcessBoundary cut = new ProcessBoundary();
        String process = cut.createNewProcessId();
        assertThat(process, notNullValue());
    }
}
