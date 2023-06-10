import java.math.BigInteger;
class Solution {
    public int solution(int balls, int share) {
        int answer = 0;

        BigInteger bN[] = new BigInteger[balls+1];

        bN[0]= new BigInteger("1");
        for(int i=1;i<=balls;i++) {

                bN[i] = new BigInteger(Integer.toString(i));
                bN[i] = bN[i].multiply(bN[i-1]);
        }

        answer=bN[balls].divide(bN[share].multiply(bN[balls-share])).intValue();

         return answer;
    }

}