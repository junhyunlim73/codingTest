import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static long[][] matrix;
    static long[][] reuslt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        BigInteger N = new BigInteger(input);

        reuslt = new long[][]{{1, 0}, {0, 1}};
        matrix = new long[][]{{1,1},{1,0}};

        while(N.compareTo(BigInteger.ZERO) > 0) {

            if(N.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                reuslt = mulMatrix(reuslt, matrix);
            }

            matrix = mulMatrix(matrix, matrix);
            N = N.shiftRight(1);
        }

        System.out.println(reuslt[1][0]);
        br.close();
    }

    private static long[][] mulMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[2][2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    res[i][j] += ((matrix1[i][k] % 1000000) * (matrix2[k][j] % 1000000)) % 1000000;
                    res[i][j] %= 1000000;
                }
            }
        }

        return res;
    }

}