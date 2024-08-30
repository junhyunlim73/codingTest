import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, -1);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, String.valueOf(N)));
        visited[N] = 0;

        if(N < K){
            while (!q.isEmpty()) {
                Node now = q.poll();
                int idx = now.idx;

                if(idx == K){
                    sb.append(visited[idx]).append("\n").append(now.str);
                    System.out.println(sb.toString());
                    break;
                }

                int idx_min = idx - 1;
                int idx_plus = idx + 1;
                int idx_mul = idx * 2;

                if(idx_min >= 0 && visited[idx_min] == -1){
                    visited[idx_min] = visited[idx] + 1;
                    q.offer(new Node(idx_min, now.str + " " + idx_min));
                }

                if(idx_plus < 100001 && visited[idx_plus] == -1){
                    visited[idx_plus] = visited[idx] + 1;
                    q.offer(new Node(idx_plus, now.str + " " + idx_plus));
                }

                if(idx_mul < 100001 && visited[idx_mul] == -1){
                    visited[idx_mul] = visited[idx] + 1;
                    q.offer(new Node(idx_mul, now.str + " " + idx_mul));
                }

            }
        }else if(N == K){
            sb.append(visited[K]).append("\n").append(N);
            System.out.println(sb);
        }else{
            sb.append(N - K).append("\n");
            for(int i = N; i >= K; i--){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }

        br.close();
    }

    static class Node{
        int idx;
        String str;

        public Node(int idx, String str){
            this.idx = idx;
            this.str = str;
        }
    }

}