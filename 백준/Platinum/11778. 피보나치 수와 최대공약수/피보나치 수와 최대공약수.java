import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long g = gcd(N, M);
        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = {{1, 0}, {0, 1}};

        while(g > 0){
            if((g & 1) == 1)
                result = mulMatrix(result, matrix);

            matrix = mulMatrix(matrix, matrix);
            g >>= 1;
        }

        System.out.println(result[1][0]);
        br.close();
    }

    private static long gcd(long n, long m){

        while(m > 0){
            long r = n % m;
            n = m;
            m = r;
        }

        return n;
    }

    private static long[][] mulMatrix(long[][] matrix1, long[][] matrix2){
        long[][] result = new long[2][2];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]) % 1000000007;
                }
                result[i][j] %= 1000000007;
            }
        }

        return result;
    }

}