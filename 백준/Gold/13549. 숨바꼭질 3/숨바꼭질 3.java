import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] time;
    static boolean[] visited;
    static int N, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001];
        visited = new boolean[100001];
        boolean isFind = false;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if(cur < 0 || cur > 100000)
                break;
            
            int num1 = cur - 1;
            int num2 = cur * 2;
            int num3 = cur + 1;
            
            if(num1 > -1){
                if(!visited[num1]){
                    time[num1] = time[cur] + 1;
                    q.add(num1);
                    visited[num1] = true;
                }
                if(num1 == K)
                    isFind = true;
            }

            if(num2 <= 100000){
                if(!visited[num2]){
                    time[num2] = time[cur];
                    q.add(num2);
                    visited[num2] = true;
                }
                if(num2 == K)
                    isFind = true;
            }

            if(num3 < 100001){
                if(!visited[num3]){
                    time[num3] = time[cur] + 1;
                    q.add(num3);
                    visited[num3] = true;
                }
                if(num3 == K)
                    isFind = true;
            }

            if(isFind)
                break;
        }

        System.out.println(time[K]);
        br.close();
    }

}