class Solution {
    
    private int[] stones;
    private int k;
    public int solution(int[] arr, int n) {
        stones = arr;
        k = n;
        
        int result = 0;
        int min = 0;
        int max = 200000000;
        
        while(min <= max) {
            int mid = (min + max) / 2;
            if(validateAcrossRiver(mid)) {
                min = mid + 1;
                result = Math.max(result, mid);
            } else {
                max = mid - 1;
            }
        }
        return result;
    }
    
    private boolean validateAcrossRiver(int n) {
        int count = 0;
        for(int stone:stones) {
            count = stone - n < 0 ? count + 1 : 0;
            if(count == k) {
                return false;
            }
        }
        return true;
    }
}