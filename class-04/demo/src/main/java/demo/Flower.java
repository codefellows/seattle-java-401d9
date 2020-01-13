package demo;

public class Flower {

    // instance variables: every instance of the class will have these properties
    int numberOfPetals;
    String color;
    boolean hasThorns;

    // define the constructor
    // constructors combine the return type and method name, because they're the same
    public Flower(int numberOfPetals, String color, boolean hasThorns) {
        this.numberOfPetals = numberOfPetals;
        this.color = color;
        this.hasThorns = hasThorns;
    }

    public Flower() {}

    // instance methods

    // toString method takes in no parameters and returns a string describing this Flower
    // does not have the word "static", so it's an instance method
    public String toSillyString() {
        return "A " + this.color + " flower";
    }

    // class methods
    // method that isn't about a single flower instance... there  is no "this"
    public static String getFertilizer() {
        return "nice compost";
    }

}
