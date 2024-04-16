import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] room;
    static int N, cnt;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        room = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] nums = br.readLine().split(" ");
            room[i][0] = Integer.parseInt(nums[0]);
            room[i][1] = Integer.parseInt(nums[1]);
        }
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        cnt = 1;
        int idx = 0;
        for(int i = 1; i < N; i++){
            if(room[idx][1] <= room[i][0]){
                idx = i;
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}