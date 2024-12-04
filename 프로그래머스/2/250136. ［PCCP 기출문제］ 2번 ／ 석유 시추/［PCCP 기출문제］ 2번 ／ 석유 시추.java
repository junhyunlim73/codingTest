import java.util.*;

class Solution {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    static boolean[][] isChecked;

    public int solution(int[][] land) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int areaId = 0;
        int r_len = land.length;
        int c_len = land[0].length;
        
        visited = new boolean[r_len][c_len];

        for(int i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int cnt = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    areaId++;
                    q.add(new int[]{i, j});
                    land[i][j] = areaId;
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];

                            if(nr < 0 || nc < 0 || nr >= r_len || nc >= c_len)
                                continue;

                            if(land[nr][nc] == 1 && !visited[nr][nc]){
                                visited[nr][nc] = true;
                                land[nr][nc] = areaId;
                                cnt++;
                                q.add(new int[]{nr, nc});
                            }
                        }   
                    }

                    map.put(areaId, cnt);
                }
            }
        }

        isChecked = new boolean[c_len][areaId+1];

        for(int i = 0; i < c_len; i++){
            int sum = 0;
            for(int j = 0; j < r_len; j++){
                int id = land[j][i];
                if(visited[j][i] && !isChecked[i][id]){
                    sum += map.get(id);
                    isChecked[i][id] = true;
                }
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }
}