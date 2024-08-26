import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        DC(0, 0, N);
        System.out.println(sb);
    }

    private static void DC(int r , int c, int n){
        int start = board[r][c];

        if(isCheck(start, r, c, n)){
            sb.append(start);
        }else{
            sb.append("(");
            int num = n / 2;
            DC(r, c, num);
            DC(r, c +  num, num);
            DC(r + num, c, num);
            DC(r + num, c + num, num);
            sb.append(")");
        }

    }

    private static boolean isCheck(int start, int r, int c, int n){
        for(int i = r; i < r + n; i++){
            for(int j = c; j < c + n; j++){
                if(board[i][j] != start){
                    return false;
                }
            }
        }
        return true;
    }

}