package org.example;

class Task{
    private int id;
    private String name;
    private int hrsToComplete;


    public Task(int id, String name, int hrsToComplete) {
        this.id = id;
        this.name = name;
        this.hrsToComplete = hrsToComplete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHrsToComplete() {
        return hrsToComplete;
    }

    public void setHrsToComplete(int hrsToComplete) {
        this.hrsToComplete = hrsToComplete;
    }
}

