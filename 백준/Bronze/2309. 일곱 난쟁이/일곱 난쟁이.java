import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] sel;
    static int[] arr;
    static boolean flag = false;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        sel = new int[7];
        arr = new int[9];

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        combi(0, 0, 0);
        System.out.println(sb.toString());
    }

    private static void combi(int idx, int depth, int sum){
        if(depth == 7){
            if(sum == 100){
                flag = true;

                for(int num : sel) {
                    sb.append(num).append("\n");
                }

            }
            return;
        }

        if(idx == 9){
            return;
        }

        for(int i = idx; i < 9; i++){
            if(!flag){
                sel[depth] = arr[i];
                combi(i+1, depth+1, sum + arr[i]);
            }
        }

    }
}