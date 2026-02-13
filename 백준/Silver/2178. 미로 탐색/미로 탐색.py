import sys
from collections import deque 
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

q = deque()
q.append([0, 0])
visited[0][0] = 1


while q:
    r, c = q.popleft()

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        if nr < 0 or nc < 0 or nr >= n or nc >= m:
            continue

        if visited[nr][nc] == 0 and graph[nr][nc] == 1:
            visited[nr][nc] = visited[r][c] + 1
            q.append([nr, nc])
        
print(visited[n-1][m-1])