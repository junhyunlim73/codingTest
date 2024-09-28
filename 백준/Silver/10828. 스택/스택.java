import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while(N --> 0){
            String[] cmd = br.readLine().split(" ");

            if(cmd[0].equals("push")){
                stack.push(Integer.parseInt(cmd[1]));
            }else if(cmd[0].equals("pop")){
                bw.write((!stack.isEmpty() ? stack.pop(): -1) + "\n");
            }else if(cmd[0].equals("size")){
                bw.write(stack.size() + "\n");
            }else if(cmd[0].equals("empty")){
                bw.write((stack.isEmpty() ? "1" : "0") + "\n");
            }else if(cmd[0].equals("top")){
                bw.write((!stack.isEmpty() ? stack.peek(): -1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}