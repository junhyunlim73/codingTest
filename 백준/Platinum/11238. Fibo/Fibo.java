import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            long[][] matrix = {{1, 1}, {1, 0}};
            long[][] result = {{1, 0}, {0, 1}};

            int r = gcd(N, M);

            while(r > 0){
                if((r & 1) == 1){
                    result = mulMatrix(result, matrix);
                }

                matrix = mulMatrix(matrix, matrix);
                r >>= 1;
            }

            bw.write(result[1][0] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        while(b > 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private static long[][] mulMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[2][2];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    result[i][j] += ((matrix1[i][k] % 1000000007) * (matrix2[k][j] % 1000000007)) % 1000000007;
                }
                result[i][j] %= 1000000007;
            }
        }

        return result;
    }

}