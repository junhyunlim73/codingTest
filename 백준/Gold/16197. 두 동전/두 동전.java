import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;
    static int r1, c1, r2, c2;
    static int[] dr = {0,0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int min = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();

            for(int j = 0; j < M; j++){
                board[i][j] = arr[j];

                if(arr[j] == 'o'){
                    list.add(new int[]{i, j});
                }
            }
        }

        ArrayDeque<Coin> coins = new ArrayDeque<>();
        coins.add(new Coin(list.get(0)[0], list.get(0)[1], list.get(1)[0], list.get(1)[1], 1));

        while (!coins.isEmpty()){
            Coin coin = coins.poll();
            int r1 = coin.r1;
            int c1 = coin.c1;
            int r2 = coin.r2;
            int c2 = coin.c2;
            int cnt = coin.cnt;

            if(cnt > 10)
                continue;

            for (int i = 0; i < 4; i++){
                boolean flag1 = false;
                boolean flag2 = false;

                int nr1 = r1 + dr[i];
                int nc1 = c1 + dc[i];
                int nr2 = r2 + dr[i];
                int nc2 = c2 + dc[i];

                if(nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= M){
                    flag1 = true;
                }

                if(nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= M){
                    flag2 = true;
                }

                if(flag1 && flag2)
                    continue;
                else if(!flag1 && !flag2){
                    int nr3, nr4, nc3, nc4;

                    if(board[nr1][nc1] == '#'){
                        nr3 = r1;
                        nc3 = c1;
                    }else{
                        nr3 = nr1;
                        nc3 = nc1;
                    }

                    if(board[nr2][nc2] == '#'){
                        nr4 = r2;
                        nc4 = c2;
                    }else{
                        nr4 = nr2;
                        nc4 = nc2;
                    }

                    coins.add(new Coin(nr3, nc3, nr4, nc4, cnt+1));
                }else{
                    System.out.println(cnt);
                    return;
                }

            }

        }

        if(min == 11)
            System.out.println(-1);

        br.close();
    }

    static class Coin{
        int r1, c1, r2, c2, cnt;

        public Coin(int r1, int c1, int r2, int c2, int cnt){
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.cnt = cnt;
        }

    }

}