import sys
from collections import deque 
input = sys.stdin.readline

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]
ans = []

def isCheck(r, c, n, m):
    if r < 0 or c < 0 or r >= n or c >= m:
        return False
    
    return True

def bfs(r, c, n, m, visited):
    cnt = 1

    q = deque()
    q.append([r, c])
    visited[r][c] = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dr[i]
            ny = y + dc[i]

            if isCheck(nx, ny, n, m) and visited[nx][ny] == 0:
                q.append([nx, ny])
                visited[nx][ny] = 1
                cnt += 1

    return cnt

m, n, k = map(int, input().split())
visited = [[0] * m for _ in range(n)]

for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())

    for j in range(x1, x2):
        for z in range(y1, y2):
            visited[j][z] = 1

for i in range(n):
    for j in range(m):
        if visited[i][j] == 0:
            ans.append(bfs(i, j, n, m, visited))

ans.sort()
print(len(ans))
print(" ".join(map(str, ans)))