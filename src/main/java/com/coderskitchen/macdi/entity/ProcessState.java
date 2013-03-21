package com.coderskitchen.macdi.entity;

public class ProcessState {
    private String userToken;
    private String processId;

    public enum State {RUNNING, STOPPED, DONE};

    private State currentState = State.STOPPED;

    public ProcessState(String userToken, String processId) {


        this.userToken = userToken;
        this.processId = processId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setRunningState() {
        currentState = State.RUNNING;
    }

    public State getCurrentState() {
        return currentState;
    }
}
