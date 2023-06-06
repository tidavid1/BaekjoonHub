class Solution {
    public int solution(int n, String control) {
        char[] ctr = control.toCharArray();
        for(char c: ctr){
            switch(c){
                case 'w':
                    n +=1;
                    break;
                case 's':
                    n -=1;
                    break;
                case 'd':
                    n += 10;
                    break;
                default:
                    n -= 10;
            }    
        }
        
        return n;
    }
}