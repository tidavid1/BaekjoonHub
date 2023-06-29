class Solution{
    public int solution(int n, int a, int b){
        int count = 1;
        boolean flag = a<b;
        for(int i=0;i<n;i++){
            if(flag){
                if(a+1 == b && a%2 == 1){
                    break;
                }
            }else{
                if(b+1 == a && b%2 == 1){
                    break;
                }
            }
            count += 1;
            a = a%2 == 0 ? a/2 : a/2+1;
            b = b%2 == 0 ? b/2 : b/2+1;

        }
        return count;
    }
}