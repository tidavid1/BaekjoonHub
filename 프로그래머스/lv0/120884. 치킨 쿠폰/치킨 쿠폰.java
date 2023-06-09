class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon;
        do{
            answer += chicken/10;
            coupon = chicken%10 + chicken/10;
            chicken =coupon;
        } while(coupon/10 != 0);
        return answer;
    }
}