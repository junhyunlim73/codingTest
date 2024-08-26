import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 수열 크기
        arr = new int[n];
        int cnt = 0;
        int start = 0; // 시작 인덱스
        int end = n - 1; // 끝 인덱스
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 수열
        }

        int x = Integer.parseInt(br.readLine()); // 목표

        Arrays.sort(arr); // 정렬

        while(start < end) {
            int sum = arr[start] + arr[end]; // 두 수의 합

            if(x <= sum){
                end--;
                if(sum == x)
                    cnt++;
            }else
                start++;
        }
        
        System.out.println(cnt); // 쌍 출력
    }

}