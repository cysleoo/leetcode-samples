package array;

/**
 * @author ssliu
 * @date 2020-09-29
 */
public class JumpingGame55 {

  public static void main(String[] args) {
    int [] nums = { 5,9,3,2,1,0,2,3,3,1,0,0 };
    System.out.println(jumpingGameSai(nums));
  }

  static boolean jumpingGameSai(int[] nums) {

    int maxJump = nums[0];

    for (int i = 0; i < nums.length; i++) {
      if (maxJump  >= i) {
        maxJump = Math.max(maxJump, nums[i] + i);
        if (maxJump >= nums.length - 1) {
          return true;
        }
      }
    }
    return false;
  }





}
