// WARMUP
// Write a method (no recursion, just loops) that takes in a number n and returns a string of n asterisks/stars/*
// i.e. stars(3) => "***"

public class Stars {
  public static void main(String[] args) {
    // System.out.println(tri(8));
    // System.out.println();
    // System.out.println(pyramid(8));

    System.out.println(diamond(6));
  }

  public static String stars(int n) {
    if (n == 0) {
      return "";
    } else {
      String firstPartOfString = stars(n-1);
      return firstPartOfString + "*";
    }
  }


  public static String k(int n) {
    if(n == 1) {
      return "*\n*";
    } else {
      return stars(n) + 
        "\n" + 
        k(n-1) + 
        "\n" +
        stars(n);
    }
  }
  public static String tri(int n) {
    if(n == 1) {
      return "*";
    } else {
      return stars(n) + "\n" + tri(n-1);
    }
  }

  public static String pyramid(int n) {
    if (n == 1) {
      return "*";
    } else {
      return pyramid(n-1) + "\n" + stars(n);
    }
  }

  public static String diamond(int n) {
    StringBuilder answer = new StringBuilder();
    for (int curr = 1; curr <= n; curr++) {
      // append the starting spaces
      for (int j = 0; j < n - curr; j++) {
        answer.append(" ");
      }
      // append the annoying stars
      for (int j = 0; j < curr; j++) {
        answer.append("*");
        if (j < curr - 1) {
          answer.append(" ");
        }
      }
      answer.append("\n");
    }
    for (int curr = n - 1; curr > 0; curr--) {
      for (int j = 0; j < n - curr; j++) {
        answer.append(" ");
      }
      // append the annoying stars
      for (int j = 0; j < curr; j++) {
        answer.append("*");
        if (j < curr - 1) {
          answer.append(" ");
        }
      }
      answer.append("\n");
    }
    return answer.toString();
  }

  
  // public static String stars(int n) {
  //   // Write a method (no recursion, just loops) that takes in a number n and returns a string of n asterisks/stars/*
  //   // i.e. stars(3) => "***"
  //   // stars(5) => "*****"
  //   // stars(0) => ""
  //   StringBuilder answer = new StringBuilder();
  //   for (int i = 0; i < n; i++) {
  //     answer.append("*");
  //   }
  //   return answer.toString();
  // }
}
