import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] arr_sorted = new int[N];
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr_sorted[i] = arr[i];
        }

        Arrays.sort(arr_sorted);

        for(int i = 0; i < N; i++){
            if(!map.containsKey(arr_sorted[i])){
                map.put(arr_sorted[i], rank++);
            }
        }

        for(int num : arr){
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);

    }
}