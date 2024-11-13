import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Genre> hm = new HashMap<>();
        
        for(int i=0; i< genres.length; i++){
            Genre currGen = hm.get(genres[i]);
            if(currGen == null){
                Genre genre = new Genre(genres[i]);
                hm.put(genres[i], genre.addSong(plays[i],i));
                continue;
            }
            hm.put(genres[i], currGen.addSong(plays[i],i));
        }
        
        List<Genre> genList = hm.values().stream()
            .sorted((a,b)->b.totalPlay-a.totalPlay)
            .collect(Collectors.toList());
        
        List<Integer> ans = new ArrayList();
        for(Genre g: genList){
            List<Song> songs = g.songs();
            for(int i=songs.size()-1; i>-1; i--){
                ans.add(songs.get(i).idx);
            }
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    
    public static class Genre{
        String name;
        PriorityQueue<Song> songs = new PriorityQueue<>(
            (a,b)->a.play-b.play == 0? b.idx-a.idx : a.play-b.play
        );
        int totalPlay=0;
        public Genre(String n){
            this.name=n;
        }
        
        public Genre addSong(int play, int idx){
            songs.add(new Song(play, idx));
            if(songs.size()>2){
                songs.poll();
            }
            this.totalPlay+=play;
            return this;
        }
        public List<Song> songs(){
            return new ArrayList<>(songs);
        }
    }
    
    public static class Song{
        int play;
        int idx;
        public Song(int p, int i){
            this.play=p; this.idx=i;
        }
    }
}