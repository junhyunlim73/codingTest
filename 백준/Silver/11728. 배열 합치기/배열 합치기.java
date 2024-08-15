import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int idx2 = 0;

        while(idx < N && idx2 < M){
            if(arr[idx] > arr2[idx2]){
                sb.append(arr2[idx2++] + " ");
            }else if(arr[idx] <= arr2[idx2]){
                sb.append(arr[idx++] + " ");
            }
        }

        if(idx == N){
            for(int i = idx2; i < M; i++){
                sb.append(arr2[i] + " ");
            }
        }else{
            for(int i = idx; i < N; i++){
                sb.append(arr[i] + " ");
            }
        }

        System.out.println(sb);
    }

}