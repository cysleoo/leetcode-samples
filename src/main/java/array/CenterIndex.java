package array;

/**
 * @author ssliu
 * @date 2020-09-21
 */
public class CenterIndex {
  public static void main(String[] args) {

    int[] test = {3,2,3,1,2,3,4,5,5,6,8,8,9};
    System.out.println(centerIndex(test));

  }

  /**
   * 中心索引
   * @param nums
   * @return
   */
  static int centerIndex(int[] nums) {
    int rightSum = 0;
    for (Integer num : nums) {
      rightSum+=num;
    }

    int leftSum = 0;

    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      System.out.println("left:"+leftSum+",right:"+rightSum);
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }

    return -1;
  }
}
