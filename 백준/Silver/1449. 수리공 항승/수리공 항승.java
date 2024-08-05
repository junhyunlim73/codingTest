import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int idx = 0;
        int tape = 0;
        boolean flag = false;

        for (int i = 1; i < N; i++) {
            if(idx == i)
                continue;

            if(i != N-1){
                int diff = arr[i] - arr[idx] + 1;

                if(diff == L){
                    tape++;
                    idx = i + 1;
                }else if(diff > L){
                    idx = i;
                    tape++;
                }
            }else{
                int diff = arr[i] - arr[idx] + 1;

                if(diff == L){
                    tape++;
                    flag = true;
                }else if(diff > L){
                    tape += 2;
                    flag = true;
                }
            }
        }

        if(!flag)
            tape++;

        System.out.println(tape);

    }

}