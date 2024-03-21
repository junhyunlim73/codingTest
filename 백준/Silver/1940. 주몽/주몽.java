import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] com = new int[n];
        int start_index = 0;
        int end_index = n-1;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
             com[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(com);
        while(start_index < end_index){
            int sum = com[start_index] + com[end_index];
            if(sum == m){
                count++;
                start_index++;
                end_index--;
            }else if(sum < m){
                start_index++;
            }else{
                end_index--;
            }
        }
        
        System.out.println(count);
        br.close();
    }
}