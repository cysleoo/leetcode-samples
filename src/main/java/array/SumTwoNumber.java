package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ssliu
 * @date 2020-09-22
 */
public class SumTwoNumber {

  public static void main(String[] args) {

  }

  /**
   * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数， 并返回他们的数组下标。
   * <p>
   * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
   *
   * @return
   */
  static int[] sumTwoNumbers(int[] nums, int target) {
    HashMap<Integer, Integer> numsMap = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      numsMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      if (numsMap.containsKey(value) && !numsMap.get(value).equals(i)) {
        return new int[] {i, numsMap.get(value)};
      }
    }
    return null;
  }

  static int[] sumTwoNumbersFastest(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (map.containsKey(key)) {
        return new int[] {map.get(key), i};
      } else {
        map.put(nums[i], i);
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }



}
