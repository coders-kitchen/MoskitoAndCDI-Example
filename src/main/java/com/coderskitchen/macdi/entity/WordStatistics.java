package com.coderskitchen.macdi.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement
public class WordStatistics {
    private String processId;
    private HashMap<String, Integer> statistics = new HashMap<String, Integer>();
    private String document;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public HashMap<String, Integer> getStatistics() {
        return statistics;
    }

    public void setStatistics(HashMap<String, Integer> statistics) {
        this.statistics = statistics;
    }
}
