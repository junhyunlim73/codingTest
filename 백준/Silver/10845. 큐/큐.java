import java.io.*;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        while (n-- > 0) {
            String[] cmd = br.readLine().split(" ");

            if(cmd[0].equals("push")) {
                queue.addLast(Integer.parseInt(cmd[1]));
            }else if(cmd[0].equals("pop")) {
                bw.write((!queue.isEmpty() ? String.valueOf(queue.removeFirst()) : "-1") + "\n");
            }else if(cmd[0].equals("size")) {
                bw.write((queue.size() + "") + "\n");
            }else if(cmd[0].equals("empty")) {
                bw.write((!queue.isEmpty() ? "0" : "1") + "\n");
            }else if(cmd[0].equals("front")) {
                bw.write((!queue.isEmpty() ? String.valueOf(queue.peekFirst()) : "-1") + "\n");
            }else if(cmd[0].equals("back")) {
                bw.write((!queue.isEmpty() ? String.valueOf(queue.peekLast()) : "-1") + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}