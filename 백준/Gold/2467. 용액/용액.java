import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] result;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        result = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if(sum > 0)
                right--;
            else
                left++;
        }

        System.out.println(result[0] + " " + result[1]);
        br.close();
    }

}