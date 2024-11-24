import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        boolean flag =false;
        
        for(String word : words){
            if(target.equals(word)){
                flag = true;
                break;
            }
        }
        
        if(!flag){
            return 0;
        }
        
        flag = false;
        
        ArrayDeque<Word> q = new ArrayDeque<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            String word = now.word;
            int cnt = now.cnt;
            
            if(word.equals(target)){
                flag = true;
                answer = cnt;
                break;
            }
            
            for(int i = 0; i < words.length; i++){
                for(int j = 0; j < word.length(); j++){
                    if(isCheck(j, word, words[i])){
                        q.add(new Word(words[i], cnt+1));
                    }
                }
            }
            
        }
        
        if(flag)
            return answer;
        
        return 0;
    }
    
    private boolean isCheck(int idx, String word1, String word2){
        for(int i = 0; i < word1.length(); i++){
            if(i == idx){
                if(word1.charAt(i) == word2.charAt(i))
                    return false;
                else
                    continue;
            }else{
                if(word1.charAt(i) != word2.charAt(i))
                    return false;
                
            }
        }
        
        return true;
    }
    
    static class Word{
        String word;
        int cnt;
        
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
        
    }
    
}