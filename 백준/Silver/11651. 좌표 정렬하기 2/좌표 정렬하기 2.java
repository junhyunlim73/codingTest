import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] nums = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(nums[0]);
            arr[i][1] = Integer.parseInt(nums[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for(int[] num : arr){
            System.out.println(num[0] + " " + num[1]);
        }
        br.close();
    }
}