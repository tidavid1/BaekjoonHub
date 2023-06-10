import java.util.*;
class Solution {
    public boolean isPrime(int n){
        if(n > 2){
            for(int i=2;i<n;i++)
                if(n%i==0) return false;  
        }
        return true;
    }
    
    public ArrayList<Integer> getDivisor(int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0 && isPrime(i)) temp.add(i);
        }
        return temp;
    }
    
    public ArrayList<Integer> solution(int n) {
        return getDivisor(n);
    }
}