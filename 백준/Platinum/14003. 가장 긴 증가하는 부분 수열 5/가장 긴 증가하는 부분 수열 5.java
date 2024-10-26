import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] lis;
    static int[] idxarr;
    static int cnt;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lis = new int[N];
        idxarr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();

        bw.write(cnt + "\n");

        int idx = cnt - 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            if (idxarr[i] == idx) {
                stack.addFirst(arr[i]);
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst()).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static void LIS() {
        lis[0] = arr[0];
        cnt = 1;

        for (int i = 1; i < N; i++) {
            if (lis[cnt - 1] < arr[i]) {
                lis[cnt] = arr[i];
                idxarr[i] = cnt;
                cnt++;
            } else {
                int idx = binarySearch(0, cnt - 1, arr[i]);
                lis[idx] = arr[i];
                idxarr[i] = idx;
            }
        }
    }
}