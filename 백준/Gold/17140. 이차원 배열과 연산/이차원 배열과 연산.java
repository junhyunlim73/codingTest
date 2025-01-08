import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A = new int[4][4];
    static int r, c, k;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 4; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(time < 101){
            int r_len = A.length;
            int c_len = A[0].length;

            if(r_len > r && c_len > c){
                if(A[r][c] == k){
                    break;
                }
            }

            if(r_len >= c_len){
                ArrayList<int[]>[] list = new ArrayList[r_len];
                int max_len = 0;

                for(int i = 0; i < r_len; i++){
                    list[i] = new ArrayList<>();
                }

                for(int i = 1; i < r_len; i++){
                    HashMap<Integer, Integer> map = new HashMap<>();

                    for(int j = 1; j < c_len; j++){
                        if(A[i][j] == 0)
                            continue;
                        map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
                    }

                    for(int key : map.keySet()){
                        list[i].add(new int[]{key, map.get(key)});
                    }

                    Collections.sort(list[i], new Comparator<int[]>(){
                        public int compare(int[] o1, int[] o2){
                            if(o1[1] == o2[1]){
                                return o1[0] - o2[0];
                            }
                            return o1[1] - o2[1];
                        }
                    });

                    max_len = Math.max(max_len, (list[i].size() * 2));
                    max_len = Math.min(max_len, 101);
                }

                A = new int[r_len][max_len+1];

                for(int i = 1; i < r_len; i++){
                    for(int j = 1; j < max_len + 1; j+=2){
                        int idx = j / 2;

                        if((idx + 1) > list[i].size())
                            break;

                        A[i][j] = list[i].get(idx)[0];
                        A[i][j+1] = list[i].get(idx)[1];
                    }
                }

            }else{
                ArrayList<int[]>[] list = new ArrayList[c_len];
                int max_len = 0;

                for(int i = 0; i < c_len; i++){
                    list[i] = new ArrayList<>();
                }

                for(int i = 1; i < c_len; i++){
                    HashMap<Integer, Integer> map = new HashMap<>();

                    for(int j = 1; j < r_len; j++){
                        if(A[j][i] == 0)
                            continue;
                        map.put(A[j][i], map.getOrDefault(A[j][i], 0) + 1);
                    }

                    for(int key : map.keySet()){
                        list[i].add(new int[]{key, map.get(key)});
                    }

                    Collections.sort(list[i], new Comparator<int[]>(){
                        public int compare(int[] o1, int[] o2){
                            if(o1[1] == o2[1]){
                                return o1[0] - o2[0];
                            }
                            return o1[1] - o2[1];
                        }
                    });

                    max_len = Math.max(max_len, (list[i].size() * 2));
                    max_len = Math.min(max_len, 101);
                }

                A = new int[max_len+1][c_len];

                for(int i = 1; i < c_len; i++){
                    for(int j = 1; j < max_len + 1; j+=2){
                        int idx = j / 2;

                        if((idx + 1) > list[i].size())
                            break;

                        A[j][i] = list[i].get(idx)[0];
                        A[j+1][i] = list[i].get(idx)[1];
                    }
                }

            }

            time++;
        }

        System.out.println(time != 101 ? time : -1);
        br.close();
    }

}