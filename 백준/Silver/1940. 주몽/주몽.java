import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int startIdx = 0;
        int endIdx = N-1;

        while(startIdx < endIdx){
            int sum = arr[startIdx] + arr[endIdx];

            if(sum == M) {
                cnt++;
                startIdx++;
                endIdx--;
            }else if(sum > M){
                endIdx--;
            }else{
                startIdx++;
            }

        }

        System.out.println(cnt);
        br.close();
    }

}