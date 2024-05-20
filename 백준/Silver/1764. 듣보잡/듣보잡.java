import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static HashSet<String> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            map.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            String name = br.readLine();

            if(map.contains(name)){
                list.add(name);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String name : list){
            System.out.println(name);
        }

        br.close();
    }

}