import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static LinkedHashSet<String> set;
    static int[] sel;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new LinkedHashSet();
        arr = new int[N];
        sel = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        combi(0, 0);
        set.forEach(System.out::println);

        br.close();
    }

    private static void combi(int idx, int depth){
        if(depth == M){
            String str = "";

            for(int i = 0; i < M; i++){
                str += sel[i] + " ";
            }

            set.add(str);
            return;
        }

        if(idx == N){
            return;
        }

        sel[depth] = arr[idx];
        combi(idx, depth+1);
        combi(idx + 1, depth);
    }
}