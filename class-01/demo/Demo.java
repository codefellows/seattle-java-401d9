
// name of the class matches exactly the name of the file
public class Demo {
  // main method is the code that will actually be run when I compile and run this file
  // always looks the same
  public static void main(String[] args) {
    // System.out.println is our equivalent of console.log from JS
    // System.out.println("Hello world!");
    // We want to be explicit about data types in our variable declarations
    // String name = "Michelle";
    // System.out.println(name);
    // name = "true";
    // System.out.println(name);

    // char x = 'x';
    // String y = String.format("%c was the character and %c was the other character.", x, '2');
    // System.out.println(y);

    // System.out.println(isLucky(700));
    // System.out.println(isLucky(701));
    // double rand = Math.random();
    // // cast the result of Math.ceil to an int
    // int year = (int) Math.ceil(rand * 2020);
    // System.out.println(String.format("The year is %d.", year));
    // if(isLucky(year)) {
    //   System.out.println("So lucky!");
    // } else {
    //   System.out.println("Better luck next time.");
    // }

    printCountdown();

    // playing with arrays
    // With arrays in Java, you have to declare their size when you create them, and they can NEVER grow/shrink.
    // String[][] employees = new String[2][4];
    String[] fruits = new String[4];
    fruits[0] = "apple";
    fruits[1] = "banana";
    fruits[2] = "cantaloupe";
    fruits[3] = "dragonfruit";

    // or you could use shorthand, which uses curly braces
    // String[] fruits = new String[] {"apple", "banana", "cantaloupe", "dragonfruit"};
    // looping through arrays looks JUST like JS
    for(int i = 0; i < fruits.length; i++) {
      System.out.println(fruits[i]);
    }

    // good news: zero and negative zero are equal
    // int zero = 0;
    // int negZero = -0;
    // System.out.println(zero == negZero);
  }

  // our methods (like functions) follow a pattern
  // public static RETURN_TYPE METHOD_NAME(type paramName, type2 paramName2) {}

  // takes in a year and returns whether that year is "lucky"
  // takes in int: year
  // return boolean: true or false
  // aka divisible by 7

  public static boolean isLucky(int year) {
    return (year % 7 == 0);
  }

  // takes in no arguments and prints a countdown from 10 to 1, then prints "liftoff"
  // returns nothing, so the return type is void
  public static void printCountdown() {
    int n = 10;
    while (n > 0) {
      System.out.println(n);
      n--;
    }
    System.out.println("liftoff!");
  }

}
