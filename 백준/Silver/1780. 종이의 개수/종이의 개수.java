import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] cnts;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        cnts = new int[3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divAndcon(0, 0, N);

        for(int i = 0; i < 3; i++){
            System.out.println(cnts[i]);
        }
    }

    private static void divAndcon(int r, int c, int size){

        if(isCheck(r, c, size)){
            int idx = board[r][c] + 1;
            cnts[idx]++;
        }else{
            int n_size = size / 3;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    divAndcon(r + (i * n_size), c + (j * n_size), n_size);
                }
            }

        }
    }

    private static boolean isCheck(int r, int c, int size) {
        int target = board[r][c];

        for(int i = r; i < r + size; i++){
            for(int j = c; j <  c + size; j++){
                if(board[i][j] != target){
                    return false;
                }
            }
        }

        return true;
    }

}