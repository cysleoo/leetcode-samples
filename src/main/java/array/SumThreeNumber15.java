package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 三数之和
 * 题目：
 *    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *    注意：答案中不可以包含重复的三元组。
 * 示例：
 *   给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *   满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author ssliu
 * @date 2020-09-28
 */
public class SumThreeNumber15 {
  public static void main(String[] args) {
    // int[] param = {-1,0,1,2,-1,-4};
    int[] param = {0,0,0,0,0,0};

    // threeSum_Sai
    // System.out.println(threeSum_Sai(param));


  //  threeSum1
    System.out.println(threeSum1(param));

  }

  /**
   * 缺点：简单的三重循环，时间复杂度和空间复杂度都很高
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum_Sai(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        for (int k = j + 1; k < nums.length; k++) {
          if (k > j + 1 && nums[k] == nums[k - 1]) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            ArrayList<Integer> integers = new ArrayList<>(3);
            integers.add(nums[i]);
            integers.add(nums[j]);
            integers.add(nums[k]);
            result.add(integers);
          }
        }
      }
    }
    return result;
  }

  /**
   * 双指针解法
   * @param nums
   * @return
   */
  static List<List<Integer>> threeSum1(int[] nums) {
    ArrayList<List<Integer>> result = new ArrayList<>(nums.length / 3);
    // 1.排序，保证不重复
    Arrays.sort(nums);
  // 2.循环位置需要从nums.length-2开始
    for (int i = 0; i < nums.length-2; i++) {
      // 加速1：第一个数大于0，后面之和不可能为0
      if (nums[i] > 0) {
        break;
      }
      // 当和前一个元素重复时，跳过
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int target = -nums[i];
      int left = i+1, right = nums.length- 1;
      while (left < right) {
        if (nums[left] + nums[right] == target) {
          ArrayList<Integer> integers = new ArrayList<>(3);
          integers.add(nums[i]);
          integers.add(nums[left]);
          integers.add(nums[right]);
          result.add(integers);

          left++;right--;
          // 去掉相等的重复项
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }

        } else if (nums[left] + nums[right] < target) {
          left++;
        } else {
          right --;
        }
      }
    }
    return result;
  }





}
