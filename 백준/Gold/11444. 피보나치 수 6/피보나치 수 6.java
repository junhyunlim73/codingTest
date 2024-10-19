import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] matrix;
    static long[][] reuslt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        reuslt = new long[][]{{1, 0}, {0, 1}};
        matrix = new long[][]{{1,1},{1,0}};

        while(N > 0) {

            if((N & 1) == 1) {
                reuslt = mulMatrix(reuslt, matrix);
            }

            matrix = mulMatrix(matrix, matrix);
            N >>= 1;
        }

        System.out.println(reuslt[1][0]);
        br.close();
    }

    private static long[][] mulMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[2][2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    res[i][j] += ((matrix1[i][k] % 1000000007) * (matrix2[k][j] % 1000000007)) % 1000000007;
                    res[i][j] %= 1000000007;
                }
            }
        }

        return res;
    }

}