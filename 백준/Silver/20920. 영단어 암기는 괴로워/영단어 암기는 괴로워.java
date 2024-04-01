import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length() >= m){
                set.add(word);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = map.get(o2) - map.get(o1);
                if(result == 0){
                    int result2 = o2.length() - o1.length();
                    if(result2 == 0)
                        return o1.compareTo(o2);
                    return result2;
                }
                return result;
            }
        });
        for(String word : list){
            bw.append(word + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}