import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(String city:cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                cache.remove(city);
                answer +=1;
            }else{
                if(cache.size() == cacheSize){
                    cache.poll();   
                }
                answer += 5;
            }
            cache.add(city);
        }
        return cacheSize == 0 ? cities.length*5 :answer;
    }
}