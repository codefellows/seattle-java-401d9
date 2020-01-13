package gradlePractice;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListPractice {
    public static void arrayListsPractice (){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(929292);

        for(int i = 0; i < nums.size(); i++){
            System.out.println("a value in nums " + nums.get(i));
        }

        for (int number : nums){
            System.out.println("a value printed with forEach " + number);
        }

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Michelle");
        friends.add("Jeff");

        for(String friend : friends){
            System.out.println("thanks for being a great friend, " + friend);
        }
    }
}
