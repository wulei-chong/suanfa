//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3693 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public  List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        if(nums.length < 3 ){
            return result;
        }

        Arrays.sort(nums);

        for(int i = 0; nums[i] <= 0 ;i++){
            if(i+1 == nums.length){
                break;
            }

            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }

            int j = nums.length -1;
            while(i < j-1 && nums[j] >= 0){
                if(j<nums.length -1 && nums[j] == nums[j+1]){
                    j--;
                    continue;
                }

                int middle = j - 1;
                int left = nums[i];
                int right = nums[j];

                while(i < middle){
                    if((0-(left+right)) == nums[middle]){
                        List<Integer> list = new ArrayList();
                        list.add(left);
                        list.add(nums[middle]);
                        list.add(right);
                        result.add(list);
                        middle--;
                        break;
                    }
                    middle--;
                }
                j--;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
