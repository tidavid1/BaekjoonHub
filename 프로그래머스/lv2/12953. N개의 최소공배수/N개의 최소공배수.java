import java.util.Arrays;
class Solution {
    public int lcm(int i, int j){
        return i*j/gcd(i,j);
    }
    
    public int gcd(int i, int j){
        if(i%j ==0){
            return j;
        }
        return gcd(j, i%j);
    }
    
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = 0;
        if(arr.length == 1){
            return arr[0];
        }
        answer = lcm(arr[0], arr[1]);
        for(int i=2;i<arr.length;i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
        
    }
}