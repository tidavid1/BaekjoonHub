import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int len = nums.length;
        nums = Arrays.stream(nums).distinct().toArray();
        return len/2 < nums.length ? len/2:nums.length;
    }
}