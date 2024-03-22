import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        for(int k = 0; k < n; k++){
            int i = 0;
            int j = n-1;
            long num = nums[k];
            while(i < j){
                if((nums[i] + nums[j]) == num){
                    if(i != k && j != k){
                        count++;
                        break;
                    }else if(i == k){
                        i++;
                    }else{
                        j--;
                    }
                }else if((nums[i] + nums[j]) < num){
                    i++;
                }else{
                    j--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}