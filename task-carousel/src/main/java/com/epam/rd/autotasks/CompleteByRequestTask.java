package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    public int taskVal = 2;
    boolean buf = false;

    @Override
    public void execute() {
        if (buf || isFinished()) {taskVal = 0; buf = false;}
        else taskVal = 1;
    }

    @Override
    public boolean isFinished() {
        return taskVal == 0;
    }

    public void complete() {
        buf = true;
    }
}
