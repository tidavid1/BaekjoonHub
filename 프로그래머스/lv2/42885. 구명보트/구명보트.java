import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int boat = 0;
        int l = 0;
        int r = people.length-1;
        Arrays.sort(people);
        while(l<=r){
            if(people[l] + people[r] > limit){
                r--;
                answer += 1;
            }else if(people[l] + people[r] == limit){
                l++;r--;
                answer += 1;
            }else{
                boat = people[l] + people[r];
                while(boat<limit){
                    if(l==r)
                        break;
                    boat += people[++l];
                }
                answer += 1;
                r--;
            }
        }
        return answer;
    }
}