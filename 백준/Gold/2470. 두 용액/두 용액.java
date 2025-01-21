import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, result;
    static int min = 2_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min) {
                result[0] = arr[left];
                result[1] = arr[right];
                min = Math.abs(sum);
            }

            if(sum <= 0){
                left++;
            }else{
                right--;
            }

        }

        System.out.println(result[0] + " " + result[1]);
        br.close();
    }

}