import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] temps = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            temps[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(temps, new Comparator<>(){
            public int compare(String o1, String o2){
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        
        for(String temp : temps){
            answer += temp;
        }
        
        if(answer.startsWith("0"))
            return "0";
        
        return answer;
    }
}