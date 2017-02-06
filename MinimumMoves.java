public class Solution {
    int minIndex(int[] nums) {
        int min_index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min_index]) {
                min_index = i;
            }
        }
        return min_index;
    }

    boolean checkEqual(int[] nums) {
        int test = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (test != nums[i]) {
                return false;
            }
        }
        return true;
    }

    public int minMoves(int[] nums) {
        int min_index = minIndex(nums);
        int i = 0;
        for (; ; ) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (checkEqual(nums)) {
                    break;
                }
                nums[minIndex(nums)]++;
                i++;
            }
            if (checkEqual(nums)) {
                break;
            }
        }
        return i;
    }
}
