import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] sel;
    static long[] nums;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[1000001];
        cnt = 10;
        Arrays.fill(nums, -1);
        visited = new boolean[10];

        for(int i = 0; i < 10; i++){
            nums[i] = i;
        }

        for(int i = 2; i < 11; i++){
            sel = new int[i];
            perm(0, i, 0);
        }
        
        System.out.println(nums[N]);
    }

    private static void perm(int depth, int purpose, long sum){
        if(depth == purpose){
            nums[cnt++] = sum;
           return;
        }

        if(depth == 0){
            for(int i = 1; i <= 9; i++){
                if(!visited[i]){
                    visited[i] = true;
                    sel[depth] = i;
                    perm(depth + 1, purpose, i);
                    visited[i] = false;
                }
            }
        }else{
            for(int i = 0; i <= 9; i++){
                if(!visited[i]){
                    if(sel[depth-1] > i){
                        visited[i] = true;
                        sel[depth] = i;
                        perm(depth+1, purpose, sum * 10 + i);
                        visited[i] = false;
                    }
                }
            }
        }

    }
}