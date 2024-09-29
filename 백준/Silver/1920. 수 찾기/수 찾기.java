import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] targets;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {

            if(binarySearch(arr, targets[i])) {
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}