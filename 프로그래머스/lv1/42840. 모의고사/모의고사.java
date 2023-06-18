import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] scores = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == first[i%5]) scores[0]++;
            if(answers[i] == second[i%8]) scores[1]++;
            if(answers[i] == third[i%10]) scores[2]++;
        }
        
        int max = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<scores.length;i++){
            if(scores[i] == max) answer.add(i+1);
        }
        return answer;
    }
}