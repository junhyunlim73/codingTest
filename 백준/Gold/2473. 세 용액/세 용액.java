import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int N;
    static long[] result;
    static boolean flag;
    static long min = 3000000001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        result = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start ;
        int end;

        for(int i = 0; i <= N - 3; i++){
            start = i + 1;
            end = N - 1;

            while(start < end){
                long sum = arr[start] + arr[end] + arr[i];

                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    result[0] = arr[start];
                    result[1] = arr[end];
                    result[2] = arr[i];
                }

                if(sum > 0){
                    end--;
                }else{
                    start++;
                }
            }

        }

        Arrays.sort(result);

        for(int i = 0; i < 3; i++){
            System.out.print(result[i] + " ");
        }

        br.close();
    }

}