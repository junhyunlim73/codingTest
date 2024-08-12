import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static int[] arr;
    static int avg;
    static int mid;
    static int many;
    static int ran;
    static int[] plus;
    static int[] minus;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int sum = 0;
        arr = new int[N];
        plus = new int[4001];
        minus = new int[4001];
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            if(arr[i] >= 0){
                plus[arr[i]]++;

                if(cnt < plus[arr[i]]){
                    list = new ArrayList<>();
                    cnt = plus[arr[i]];
                    list.add(arr[i]);
                }else if(cnt == plus[arr[i]]){
                    list.add(arr[i]);
                }

            }else{
                int num = arr[i] * (-1);
                minus[num]++;

                if(cnt < minus[num]){
                    list = new ArrayList<>();
                    cnt = minus[num];
                    list.add(arr[i]);
                }else if(cnt == minus[num]){
                    list.add(arr[i]);
                }
            }

        }

        Arrays.sort(arr);

        avg = (int)Math.round((double) sum / N);

        if(list.size() == 1){
            many = list.get(0);
        }else{
            Collections.sort(list);
            many = list.get(1);
        }

        mid = arr[N/2];

        if(N != 1){
            ran = arr[N-1] - arr[0];
        }else{
            ran = 0;
        }

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(many);
        System.out.println(ran);
    }

}