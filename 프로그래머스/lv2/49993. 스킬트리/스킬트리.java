class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s: skill_trees){
            s = s.replaceAll("[^"+skill+"]", "");
            answer += skill.indexOf(s) == 0 ? 1 : 0;
        }
        return answer;
    }
}