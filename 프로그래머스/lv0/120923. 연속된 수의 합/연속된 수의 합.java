class Solution {
    public int sum(int n){
        int answer = 0;
        for(int i=1;i<n;i++) answer +=i;
        return answer;
    }
    public int[] solution(int num, int total) {
        int temp = (total-sum(num))/num;
        int[] answer = new int[num];
        for(int i=0;i<answer.length;i++) answer[i] = temp++;
        return answer;
    }
}