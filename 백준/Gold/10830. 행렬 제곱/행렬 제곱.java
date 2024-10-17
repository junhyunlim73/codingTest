import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] matrix;
    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        board = new int[N][N];
        matrix = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j)
                    matrix[i][j] = 1;
            }
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(B > 0){

            if((B & 1) == 1)
                matrix = matrixMultiple(matrix, board);

            board = matrixMultiple(board, board);
            B >>= 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }

    private static int[][] matrixMultiple(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    result[i][j] += ((matrix1[i][k] % 1000) * (matrix2[k][j] % 1000)) % 1000;
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }

}