import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        if(len % 2 == 1)
            return 0;
        

        for(int i = 0; i < len; i++){
            String temp = s.substring(i, len) + s.substring(0, i);
            char[] arr = temp.toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean flag = false;
            
            for(char ch : arr){
                if(ch == '}'){
                    if(stack.isEmpty()){
                        flag = true;
                        break;
                    }
                    
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else{
                        flag = true;
                        break;
                    }
                    
                }else if(ch == ']'){
                    if(stack.isEmpty()){
                        flag = true;
                        break;
                    }
                    
                    if(stack.peek() == '['){
                        stack.pop();
                    }else{
                        flag = true;
                        break;
                    }
                    
                }else if(ch == ')'){
                    if(stack.isEmpty()){
                        flag = true;
                        break;
                    }
                    
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        flag = true;
                        break;
                    }
                    
                }else{
                    stack.push(ch);
                }
            }
            
            if(!flag)
                answer++;
        }
        
        return answer;
    }
}