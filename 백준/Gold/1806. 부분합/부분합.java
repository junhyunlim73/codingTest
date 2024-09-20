import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int prefix = arr[end];
        int min = 100001;
        int len = 1;

        while(end < N){
            if(prefix < M){
                end++;

                if(end < N){
                    prefix += arr[end];
                }
                
                len++;
            }else{
                min = Math.min(min, len);
                prefix -= arr[start];
                start++;
                len--;
            }
        }

        System.out.println(min != 100001 ? min : 0);
        br.close();
    }

}