import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] snail;
    static int N, target;
    static int targetR = 0, targetY = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        snail = new int[N][N];
        int r = -1;
        int c = 0;
        int d = 0;
        int num = N * N;
        for(int i = N * 2; i > 1; i--){
            for(int j = 0; j < i / 2; j++){
                r = r + dr[d%4];
                c = c + dc[d%4];
                snail[r][c] = num;
                num--;
            }
            d++;
        }
        print(snail);
        br.close();
    }

    static void print(int[][] graph){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(target == graph[i][j]){
                    targetR = i + 1;
                    targetY = j + 1;
                }
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(targetR + " " + targetY);
    }
}