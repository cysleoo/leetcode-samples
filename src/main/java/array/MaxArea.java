package array;

/**
 * @author ssliu
 * @date 2020-09-22
 */
public class MaxArea {

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea1(height));
    System.out.println(maxArea0(height));
  }

  static int maxArea1(int[] height) {

    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        if (height[i] > height[j] && maxArea < (j - i) * height[j]) {
          maxArea = (j - i) * height[j];
        } else if (height[i] <= height[j] && maxArea < (j - i) * height[i]) {
          maxArea = (j - i) * height[i];
        }
      }
    }

    return maxArea;
  }

  /**
   * 双指针方法解
   * <p>
   * 分区，记录每个分区的最大的，通过比较来选择最终结果
   * <p>
   * 双指针：看作是容器的左右两边界
   *
   * @param height
   * @return
   */
  static int maxArea0(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int newArea = (right - left) * Math.min(height[left], height[right]);
      maxArea = Math.max(maxArea,newArea);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }

}
