import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int idx1 = search1(0, N-1, start);
            int idx2 = search2(0, N-1, end);

            if(idx1 <= idx2){
                sb.append(idx2 - idx1 + 1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static int search1(int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return left;
    }

    private static int search2(int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return right;
    }

}