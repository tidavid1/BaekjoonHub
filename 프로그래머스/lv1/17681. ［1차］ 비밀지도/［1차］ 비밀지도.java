class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i =0;i<n;i++){
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            temp = temp.length()<n?"0".repeat(n-temp.length())+temp:temp;
            temp = temp.replaceAll("1" , "#").replaceAll("0" , " ");
            answer[i] = temp;
        }
        return answer;
    }
}