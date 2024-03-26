import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int num = 1;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        while(num <= n){
            if(stack.isEmpty()){
                stack.push(num++);
                list.add("+");
            }else{
                int pop = stack.pop();
                if(pop == arr[index]){
                    list.add("-");
                    index++;
                } else{
                    stack.push(pop);
                    stack.push(num++);
                    list.add("+");
                }
            }
        }

        for(int i = index; i < n; i++){
            int pop = stack.pop();
            if(pop == arr[i]){
                list.add("-");
            }else{
                stack.push(pop);
                break;
            }
        }

        if(stack.isEmpty()){
            for(String s : list){
                System.out.println(s);
            }
        }else{
            System.out.println("NO");
        }
        
        br.close();
    }
}