//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 👍 4427 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    /*
    答案花里胡哨，我选择归并+哨兵
    归并算法思想，两个数组合起来，取到中间时候就是值
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //计算中位数的值
        int size1 = nums1.length;
        int size2 = nums2.length;
        int num = size1 + size2;

        if(num == 0 ){
            return 0;
        }

        int middle1 = num/2;
        int middle = (num-1)/2;

        int sum = 0;

        //整一个哨兵
        int[] left = new int[size1+1];
        int[] right = new int[size2+1];

        for(int i = 0;i < size1;i++){
            left[i] = nums1[i];
        }

        for(int i = 0;i < size2;i++){
            right[i] = nums2[i];
        }

        left[size1] = Integer.MAX_VALUE;
        right[size2] = Integer.MAX_VALUE;

        int i=0,j=0;
        int[] result = new int[num];
        for(int k=0;k<num;k++){

            if(left[i]<=right[j]){
                result[k] = left[i];
                i++;
            }else{
                result[k] = right[j];
                j++;
            }

            if(k == middle1 || k == middle){
                sum =sum + result[k];
            }


            if(k == middle1){
                break;
            }
        }

        if(num%2 != 0){
            sum = sum *2 ;
        }

        return (double) sum / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
