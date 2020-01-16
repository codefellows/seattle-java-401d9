package demo;

public class Unicorn {
    private String color;
    private boolean sparkles;

    public Unicorn() {};
    public Unicorn(String color, boolean sparkles) {
        this.color = color;
        this.sparkles = sparkles;
    }

    public String toString() {
        return "A " + this.color + " unicorn with sparkles = " + this.sparkles;
    }

    public void neigh() {
        System.out.println("neigh");
    }
}
