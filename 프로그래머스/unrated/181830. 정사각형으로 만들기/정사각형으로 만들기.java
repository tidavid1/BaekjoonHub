class Solution {
    public int[][] solution(int[][] arr) {
        int len = arr.length > arr[0].length ? arr.length : arr[0].length;
        int[][] answer = new int[len][len];
        for(int i=0;i<arr.length;i++){
            System.arraycopy(arr[i], 0, answer[i], 0, arr[i].length);
        }
        return answer;
    }
}