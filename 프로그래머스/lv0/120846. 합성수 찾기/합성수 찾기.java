import java.util.ArrayList;
class Solution {

    public ArrayList<Integer> get_divisor(int n){
        ArrayList<Integer> divisor = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                divisor.add(i);
            }
        }
        return divisor;
    }
    
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(get_divisor(i).size() >= 3){
                answer++;
            }
        }
        return answer;
    }
}