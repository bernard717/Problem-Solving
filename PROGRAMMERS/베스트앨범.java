import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Song implements Comparable<Song>{
    private int genre, play, num;
    public String genreName;

    Song(int genre, int play, int num, String genreName){
        this.genre = genre;
        this.play = play;
        this.num = num;
        this.genreName = genreName;
    }

    public int getNum(){
        return this.num;
    }
    @Override
    public int compareTo(Song o) {
        if(this.genre < o.genre){
            return -1;
        }
        else if(this.genre == o.genre){
            if(this.play < o.play)
                return -1;
            else if(this.play == o.play){
                if(this.num > o.num)
                    return -1;
                else
                    return 1;
            }
            else
                return 1;
        }
        else
            return 1;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        int len = genres.length;

        for(int i = 0; i < len; i++){
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
            hashMap2.put(genres[i], hashMap2.getOrDefault(genres[i], 0) + 1);
        }
        int temp = 0;
        for(Integer i : hashMap2.values()){
            if(i < 2)
                temp++;
            else
                temp += 2;
        }
        int[] answer = new int[temp];

        Song[] songs = new Song[len];
        for(int i = 0; i < len; i++){
            songs[i] = new Song(hashMap.get(genres[i]), plays[i], i, genres[i]);
        }
        Arrays.sort(songs, Comparator.reverseOrder());

        String tempStr = "";
        temp = 0;
        int idx = 0;
        for(int i = 0; i < len; i++) {
            if(tempStr.equals(songs[i].genreName)) {
                temp++;
                if (temp >= 2) continue;
            }
            else{
                temp = 0;
            }
            tempStr = songs[i].genreName;
            answer[idx] = songs[i].getNum();
            idx++;
        }
        return answer;
    }
}
