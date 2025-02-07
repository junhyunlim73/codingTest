import java.util.*;

class Solution {
    public  ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> elbum = new HashMap<>();
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        PriorityQueue<Elbum> q = new PriorityQueue<>();
        
        for(int i = 0; i < plays.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            elbum.put(genre, elbum.getOrDefault(genre, 0) + play);
            
            if(!map.containsKey(genre)){
                map.put(genre, new ArrayList<>());
            }
            
            map.get(genre).add(new Node(i, play));
        }
        
        for(String key : elbum.keySet()){
            q.add(new Elbum(key, elbum.get(key)));
        }
        
        while(!q.isEmpty()){
            Elbum e = q.poll();
            ArrayList<Node> list = map.get(e.genre);
            Collections.sort(list);
            
            if(list.size() >= 2){
                answer.add(list.get(0).idx);
                answer.add(list.get(1).idx);
            }else{
                answer.add(list.get(0).idx);
            }
            
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node>{
        int idx, play;
        
        public Node(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
        public int compareTo(Node o){
            return Integer.compare(o.play, this.play);
        }
        
    }
    
    static class Elbum implements Comparable<Elbum>{
        String genre;
        int play;
        
        public Elbum(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        
        public int compareTo(Elbum o){
            return Integer.compare(o.play, this.play);
        }
        
    }
    
}