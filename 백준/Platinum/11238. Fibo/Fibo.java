import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int r = gcd(N, M);

            int[][] result = fib(r);
            bw.write(result[0][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int[][] fib(int n) {
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = {{1, 0}, {0, 1}};  // 단위 행렬
        while (n > 0) {
            if ((n & 1) == 1) {
                result = mulMatrix(result, base);
            }
            base = mulMatrix(base, base);
            n >>= 1;
        }
        return result;
    }

    private static int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += (1L * matrix1[i][k] * matrix2[k][j]) % MOD;
                }
                result[i][j] = (int) (sum % MOD);
            }
        }
        return result;
    }
}