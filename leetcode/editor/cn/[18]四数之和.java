//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 932 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //四数之和，仿照三数之和，搞一搞四个指针试一下
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n-3; i++) {
            //去掉重复的
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            //第二个指针
            for (int j = i+1; j < n-2; j++) {
                //去重复的
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                //第三个指针,和第四个指针
                int k = j+1,l = n-1;
                while (k < l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum < target){
                        int k0 = k+1;
                        while (k0 < l && nums[k0] == nums[k]){
                            k0++;
                        }
                        k = k0;
                    }else if (sum > target){
                        int l0 = l-1;
                        while (l0 < l && nums[l0] == nums[l]){
                            l0--;
                        }
                        l = l0;
                    }else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(nums[i]);
                        arrayList.add(nums[j]);
                        arrayList.add(nums[k]);
                        arrayList.add(nums[l]);
                        arrayLists.add(arrayList);
                        int k0 = k+1;
                        while (k0 < l && nums[k0] == nums[k]){
                            k0++;
                        }
                        k = k0;

                        int l0 = l-1;
                        while (k0 < l && nums[l0] == nums[l]){
                            l0--;
                        }
                        l = l0;
                    }
                }

            }
        }

        return arrayLists;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
