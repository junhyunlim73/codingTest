import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static HashMap<Integer, int[]> homes = new HashMap<>();
    static HashMap<Integer, int[]> stores = new HashMap<>();
    static int h_cnt, s_cnt;
    static int min = Integer.MAX_VALUE;
    static int[] sel;
    static int[] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        sel = new int[M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1){
                    homes.put(h_cnt++, new int[]{i, j});
                }else if(board[i][j] == 2){
                    stores.put(s_cnt++, new int[]{i, j});
                }
            }
        }

        perm(0, 0);
        System.out.println(min);
        br.close();
    }

    private static void perm(int depth, int idx) {
        if(depth == M) {
            dists = new int[h_cnt];
            Arrays.fill(dists, Integer.MAX_VALUE);

            for(int num : sel){
                int[] now = stores.get(num);
                int r1 = now[0], c1 = now[1];
                for(int i = 0; i < h_cnt; i++){
                    int[] arr = homes.get(i);
                    int r2 = arr[0], c2 = arr[1];
                    int dist = Math.abs(r2 - r1) + Math.abs(c2 - c1);
                    dists[i] = Math.min(dist, dists[i]);
                }
            }

            int result = 0;

            for(int i = 0; i < h_cnt; i++){
                result += dists[i];
            }

            min = Math.min(result, min);
            return;
        }

        for(int i = idx; i < s_cnt; i++){
            sel[depth] = i;
            perm(depth + 1, i + 1);
        }

    }

}