import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] sel;
    static int[] checked;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];
        checked = new int[N];
        perm(0);
        br.close();
    }
    static void perm(int depth){
        if(depth == M){
            for(int num : sel){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++){
            if(checked[i] == 0){
                checked[i] = 1;
                sel[depth] = i+1;
                perm(depth + 1);
                checked[i] = 0;
            }
        }

    }
}