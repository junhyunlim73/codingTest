import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for(String city : cities){
            city = toLowerString(city);
            
            if(list.contains(city)){
                int idx = list.indexOf(city);
                answer += 1;
                list.remove(idx);
                list.add(city);
            }else{
                list.add(city);
                answer += 5;
            }
            
            if(list.size() > cacheSize)
                list.remove(0);
            
        }
        
        return answer;
    }
    
    private String toLowerString(String str){
        String lowerStr = "";
        char[] chs = str.toCharArray();
        
        for(char ch : chs){
            if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            lowerStr += ch;
        }
        
        return lowerStr;
    }
    
}