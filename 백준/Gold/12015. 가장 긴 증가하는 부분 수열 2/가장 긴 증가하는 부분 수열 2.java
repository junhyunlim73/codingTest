import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] lis;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(lis());
        br.close();
    }

    private static int binary_search(int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;

            if(lis[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }

        return end;
    }

    private static int lis(){
        lis[0] = arr[0];
        int len = 1;

        for(int i = 1; i < N; i++){
            if(lis[len-1] < arr[i]){
                lis[len++] = arr[i];
            }else if(arr[i] < lis[len-1]){
                int idx = binary_search(0, len-1, arr[i]);
                lis[idx] = arr[i];
            }
        }

        return len;
    }

}