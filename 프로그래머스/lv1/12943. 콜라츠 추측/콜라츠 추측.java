class Solution {
    public int solution(int num) {
        int answer = 0;
        double temp = (double) num;
        while(temp != 1.0){
            if(temp%2 ==0){
                temp /=2;
            }else{
                temp *=3;
                temp +=1;
            }
            answer +=1;
        }
        return answer <=500 ? answer : -1;
    }
}