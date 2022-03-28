package com.epam.rd.autotasks;

public class TaskCarousel {
    Boolean run = false;
    Task[] mass;
    int i, cap;

    public TaskCarousel(int capacity) {
        mass = new Task[capacity];
        cap = capacity;
        for (int m =0; m<cap;m++){
            mass[m] = new CountDownTask(0);
        }
        i=0;
    }

    public boolean addTask(Task task) {
        int m;
        if (task.isFinished() || isFull()) return false;
        for (m = 0; m < cap && !mass[m].isFinished(); m++);
        mass[m] = task;
        return true;
    }

    public boolean execute() {
        if (isEmpty()) return false;
        while (mass[i].isFinished()){
            i++;
            if (i == cap) i=0;
        }
        mass[i].execute();
        i++; if (i == cap) i=0;
        return true;
    }

    public boolean isFull() {
        int m;
        for (m = 0; m < cap && !mass[m].isFinished(); m++);
        return m == cap;
    }

    public boolean isEmpty() {
        if (mass == null) return true;
        int m;
        for (m = 0; m < cap && mass[m].isFinished(); m++);
        return m == cap;
    }

}
