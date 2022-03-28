package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    public int taskVal;

    public CountDownTask(int value) {
        taskVal = Math.max(value, 0);
    }

    public int getValue() {
        return taskVal;
    }

    @Override
    public void execute() {
        if (taskVal != 0) taskVal--;
    }

    @Override
    public boolean isFinished() {
        return taskVal == 0;
    }
}
