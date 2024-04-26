import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] board;
    static int min = 33;
    static String[][] white;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        white = new String[8][8];

        int c = N - 7;
        int r = M - 7;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0)
                        white[i][j] = "W";
                    else
                        white[i][j] = "B";
                }else{
                    if(j % 2 == 1)
                        white[i][j] = "W";
                    else
                        white[i][j] = "B";
                }
            }
        }

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++){
                board[i][j] = line[j];
            }
        }

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                min = Math.min(min, count(i, j));
            }
        }
        System.out.println(min);
        br.close();
    }

    static int count(int c, int r){
        int cnt = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(!white[i][j].equals(board[i+c][j+r]))
                    cnt++;
            }
        }
        return Math.min(cnt, 64-cnt);
    }
}