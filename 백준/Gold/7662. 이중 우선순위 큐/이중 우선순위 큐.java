import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                long num = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else if(cmd.equals("D")) {
                    if(num == -1){
                        if(!map.isEmpty()){
                            long key = map.firstKey();
                            map.put(key, map.getOrDefault(key, 0) - 1);

                            if(map.get(key) == 0){
                                map.remove(key);
                            }
                        }
                    }else{
                        if(!map.isEmpty()){
                            long key = map.lastKey();
                            map.put(key, map.getOrDefault(key, 0) - 1);

                            if(map.get(key) == 0){
                                map.remove(key);
                            }
                        }
                    }
                }
            }

            if(map.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}