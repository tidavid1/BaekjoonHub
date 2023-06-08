import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
        BigInteger answer = new BigInteger(a);
        answer = answer.add(new BigInteger(b));
        return answer.toString();
    }
}