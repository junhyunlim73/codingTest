import java.io.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            N = Long.parseLong(br.readLine());

            if(N == -1)
                break;

            if(N == 0){
                bw.write(0 + "\n");
                continue;
            }

            int[][] matrix = {{1,1}, {1, 0}};
            int[][] result = {{1, 0}, {0, 1}};

            while(N > 0){

                if((N & 1) == 1)
                    result = mulMatrix(result, matrix);

                matrix = mulMatrix(matrix, matrix);
                N >>= 1;
            }

            bw.write(result[1][0] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] mulMatrix(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[2][2];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    result[i][j] += ((matrix1[i][k]  % 10000) * (matrix2[k][j] % 10000)) % 10000;
                    result[i][j] %= 10000;
                }
            }
        }

        return result;
    }

}