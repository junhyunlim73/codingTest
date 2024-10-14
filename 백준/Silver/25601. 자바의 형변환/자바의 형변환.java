import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class Main {
    static int N;
    static String str1, str2;
    static HashMap<String, ArrayList<String>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String key = st.nextToken();

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(value);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        str2 = st.nextToken();

        if(map.containsKey(str1)) {
            dfs(str1, str2);

        }

        if(map.containsKey(str2)) {
            dfs(str2, str1);
        }

        System.out.println(0);
    }

    private static void dfs(String key, String target) {
        ArrayList<String> list = map.get(key);

        if(list.contains(target)) {
            System.out.println(1);
            exit(0);
        }else{
            for(String str : list){
                if(map.containsKey(str)) {
                    dfs(str, target);
                }
            }
        }
    }
}