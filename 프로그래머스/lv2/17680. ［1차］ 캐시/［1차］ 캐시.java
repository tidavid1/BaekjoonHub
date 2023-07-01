import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(String city:cities){
            city = city.toUpperCase();
            if(cache.size() < cacheSize){
                if(cache.contains(city)){
                    cache.remove(city);
                    answer +=1;
                }else{
                    answer += 5;    
                }
                cache.add(city);
                continue;
            }
            if(cache.contains(city)){
                cache.remove(city);
                answer +=1;
            }else{
                cache.poll();
                answer += 5;
            }
            cache.add(city);
        }
        return cacheSize == 0 ? cities.length*5 :answer;
    }
}