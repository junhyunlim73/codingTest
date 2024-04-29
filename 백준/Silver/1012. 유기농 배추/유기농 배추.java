import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, M, K;
    static int X, Y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean visited[][];
    static int arr[][];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        T  = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[M][N];
            arr = new int[M][N];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }
            Queue<int[]> queue = new ArrayDeque<>();
            for(int j = 0; j < M; j++){
                for(int k = 0; k < N; k++){
                    if(arr[j][k] == 1){
                        cnt++;
                        queue.add(new int[] {j, k});
                        visited[j][k] = true;
                        arr[j][k] = 2;
                        while(!queue.isEmpty()){
                            int[] cur = queue.poll();
                            int x = cur[0];
                            int y = cur[1];
                            arr[x][y] = 2;

                            for(int m = 0; m < 4; m++){
                                int nx = x + dx[m];
                                int ny = y + dy[m];

                                if(nx < 0 || ny < 0 || nx >= M || ny >= N ||  arr[nx][ny] != 1 || visited[nx][ny])
                                    continue;

                                queue.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}