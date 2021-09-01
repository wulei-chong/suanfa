//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 👍 866 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        //反正求和先排序，没错
        Arrays.sort(nums);
        Map map = new HashMap();
        int min = Integer.MAX_VALUE;
        int result = 0;
        //第一个指针
        for(int first = 0 ; first < n ; first ++){
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int firstnum = nums[first];
            int second = first +1 ,tried = n-1;
            while(second < tried){
                int sum = firstnum + nums[second] + nums[tried];
                if(sum == target){
                    return sum;
                }

                if(Math.abs(sum - target) < min){
                    result = sum;
                    min = Math.abs(sum - target);
                }

                //接下来是让他们更接近，如果大了就往小变
                if(sum > target){
                        tried--;
                }else{
                        second++;
                }

            }
        }

        return result;
    }
//    public static void main(String args[]){
//        Solution16.threeSumClosest(new int[]{0,2,1,-3},1);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
