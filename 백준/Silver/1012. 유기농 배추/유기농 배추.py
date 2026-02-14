import sys
from collections import deque 
input = sys.stdin.readline

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]
ans = []
t = int(input())

for i in range(t):
    n, m, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]

    cnt = 0

    for i in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                q = deque()
                q.append([i, j])
                graph[i][j] = 0


                while q:
                    r, c = q.popleft()

                    for d in range(4):
                        nr = r + dr[d]
                        nc = c + dc[d]

                        if (0 <= nr < n) and (0 <= nc < m):
                            if graph[nr][nc] == 1:
                                q.append([nr, nc])
                                graph[nr][nc] = 0

                cnt = cnt + 1

    ans.append(cnt)

print('\n'.join(map(str, ans)))