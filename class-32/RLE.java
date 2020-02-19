import java.util.*;
public class RLE {
    public static void main(String[] args) {
        for(String toEncode : args) {
            System.out.println(encode(toEncode));
        }
    }

    public static String encode(String in) {
        StringBuilder answer = new StringBuilder();
        char letter = in.charAt(0);
        int currentCount = 1;
        for(int i = 1; i < in.length(); i++) {
            if (letter == in.charAt(i)) {
                currentCount++;
            } else {
                answer.append(letter);
                answer.append(currentCount);
                currentCount = 1;
                letter = in.charAt(i);
            }
        }
        answer.append(letter);
        answer.append(currentCount);
        return answer.toString();
    }

    public static String encodeBest(String in) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while(i < in.length()) {
            char curr = in.charAt(i);
            int count = 0;
            do {
                count++;
                i++;
            } while (i < in.length() && in.charAt(i) == curr);
            answer.append(curr);
            answer.append(count);
        }
        return answer.toString();
    }
}
