package ro.jademy.millionaire.model;

public class Lifeline {

    private String name;
    private boolean used;

    public Lifeline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
