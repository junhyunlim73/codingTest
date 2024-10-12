import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> q = new ArrayDeque<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
            int cnt = 0;
            boolean flag = false;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                q.add(i);
                map.put(i, Integer.parseInt(st.nextToken()));
                pq.offer(map.get(i));
            }

            while(!flag){
                int idx = q.poll();
                int num = map.get(idx);
                int max = pq.peek();

                if(num < max){
                    q.addLast(idx);
                }else if(num == max){
                    pq.poll();
                    cnt++;

                    if(idx == target){
                        flag = true;
                    }
                }

            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}