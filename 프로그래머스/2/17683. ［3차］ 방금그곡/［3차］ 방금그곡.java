class Solution {

    private String[] titles;
    private String[] music;

    public String solution(String s, String[] musicInfos) {
        String answer = "";
        int length = 0;
        s = replaceSharp(s);
        titles = new String[musicInfos.length];
        music = new String[musicInfos.length];
        splitMusicInfos(musicInfos);
        for (int i = 0; i < music.length; i++) {
            if (music[i].contains(s) && music[i].length() > length) {
                answer = titles[i];
                length = music[i].length();
            }
        }
        return answer.isEmpty() ? "(None)" : answer;

    }

    private String replaceSharp(String s) {
        return s.replaceAll("C#", "H").replaceAll("D#", "I").replaceAll("F#", "J")
            .replaceAll("G#", "K").replaceAll("A#", "L").replaceAll("B#", "M");
    }

    private void splitMusicInfos(String[] musicInfos) {
        for (int i = 0; i < musicInfos.length; i++) {
            var musicInfo = musicInfos[i].split(",");
            var musicLength = calculateMinutes(musicInfo[0], musicInfo[1]);
            titles[i] = musicInfo[2];
            music[i] = calculateMusic(musicInfo[3], musicLength);
        }
    }

    private int calculateMinutes(String startTime, String endTime) {
        var startHour = Integer.parseInt(startTime.substring(0, 2));
        var startMinutes = Integer.parseInt(startTime.substring(3));
        var endHour = Integer.parseInt(endTime.substring(0, 2));
        var endMinutes = Integer.parseInt(endTime.substring(3));
        return (endHour * 60 + endMinutes) - (startHour * 60 + startMinutes);
    }

    private String calculateMusic(String music, int length) {
        music = replaceSharp(music);
        if (music.length() > length) {
            return music.substring(0, length);
        } else if (music.length() == length) {
            return music;
        } else {
            var i = length / music.length();
            var j = length % music.length();
            return music.repeat(i) + music.substring(0, j);
        }
    }
}
