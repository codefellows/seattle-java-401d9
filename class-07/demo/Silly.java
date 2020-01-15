public class Silly {
  public static void main(String[] args) {
int[] nums = new int[]{1,2,3,4};
int[] moreNums = nums;
nums = new int[]{6,7,8,9};
System.out.println(moreNums[0]);
  }
}
