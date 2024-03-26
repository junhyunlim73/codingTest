import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int len = n - m + 1;
        int cnt = 0;
        String temp = str.substring(0, m);
        int[] cntACGT = new int[4];
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('A', 'C', 'G', 'T'));
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 4; i++){
            map.put(list.get(i), Integer.parseInt(st.nextToken()));
            cntACGT[i] = m - temp.replace(String.valueOf(list.get(i)),"").length();
        }
        if((cntACGT[0]  >= map.get('A')) && (cntACGT[1]  >= map.get('C')) && (cntACGT[2]  >= map.get('G')) && (cntACGT[3]  >= map.get('T')))
            cnt++;

        for(int i = 1; i < len; i++){
            int index = list.indexOf(str.charAt(i-1));
            int index2 = list.indexOf(str.charAt(i+m-1));
            cntACGT[index]--;
            cntACGT[index2]++;
            if((cntACGT[0]  >= map.get('A')) && (cntACGT[1]  >= map.get('C')) && (cntACGT[2]  >= map.get('G')) && (cntACGT[3]  >= map.get('T')))
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}