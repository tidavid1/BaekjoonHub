import java.util.*;

class Solution {
    private class Music implements Comparable<Music> {
        private final int idx;
        private final int play;

        private Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Music music) {
            return Integer.compare(music.getPlay(), this.play);
        }
        public int getPlay() {
            return play;
        }
    }

    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Queue<Music>> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
            Queue<Music> queue = playMap.getOrDefault(genres[i], new PriorityQueue<>());
            queue.add(new Music(i, plays[i]));
            playMap.put(genres[i], queue);
        }
        List<String> keyList = new ArrayList<>(countMap.keySet());
        keyList.sort((o1, o2) -> countMap.get(o2) - countMap.get(o1));
        for (String genre : keyList) {
            Queue<Music> queue = playMap.get(genre);
            for (int i = 0; i < 2; i++) {
                if (queue.isEmpty()) {
                    break;
                }
                answer.add(queue.poll().idx);
            }
        }
        return answer;
    }
}