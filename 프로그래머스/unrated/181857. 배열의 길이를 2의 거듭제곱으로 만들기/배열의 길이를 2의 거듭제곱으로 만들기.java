class Solution {
    public int[] solution(int[] arr) {
        int i=1;
        for(;i<=1024;i*=2){
            if(i-arr.length >=0) break;
        }
        int[] answer = new int[i];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }
}