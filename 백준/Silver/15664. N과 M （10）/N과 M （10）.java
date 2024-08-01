import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static LinkedHashSet<String> set;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        set = new LinkedHashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        combi(0,0,"");
        set.forEach(System.out::println);

        br.close();
    }

    private static void combi(int depth, int index, String str){
        if(depth == M){
            set.add(str);
            return;
        }

        for (int i = index; i < N; i++){
            combi(depth + 1, i + 1, str + arr[i] + " ");
        }
    }
}