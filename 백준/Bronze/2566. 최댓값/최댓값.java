import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static BufferedReader br;
    static int max;
    public static void main(String[] args) throws IOException {
        matrix = new int[9][9];
        int x = 0;
        int y = 0;
        max = -1;
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);
        br.close();
    }

    static void print(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}