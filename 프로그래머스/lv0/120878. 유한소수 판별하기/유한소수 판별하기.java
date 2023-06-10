import java.util.*;

class Solution {
    public boolean is_prime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public ArrayList<Integer> get_divisor(int n){
        ArrayList<Integer> table = new ArrayList<>();
        for(int i=2;i<=n;i++)
            if(n%i==0 && is_prime(i)) table.add(i);
        return table;
    }
    public int GCD(int a, int b){
        if(b==0)return a;
        else return GCD(b, a%b);
    }
    public int solution(int a, int b) {
        ArrayList<Integer> temp = get_divisor(b/GCD(a,b));
        if(temp.size() == 0){return 1;}
        else if(temp.size() == 1){if(temp.contains(2) || temp.contains(5)) return 1;}
        else if(temp.size() == 2){if(temp.contains(2) && temp.contains(5)) return 1;}
        return 2;
    }
}