import sys
from collections import deque 
input = sys.stdin.readline

dr = [0, 0, 1, -1, 1, 1, -1, -1]
dc = [1, -1, 0, 0, 1, -1, 1, -1]
ans = []

def isCheck(r, c, n, m):
    if r < 0 or c < 0 or r >= n or c >= m:
        return False
    
    return True

def bfs(i, j, board, n, m):
    q = deque()
    q.append([i, j])
    board[i][j] = 0

    while q:
        r, c = q.popleft()

        for k in range(8):
            nr = r + dr[k]
            nc = c + dc[k]

            if isCheck(nr, nc, n, m) and board[nr][nc] == 1:
                q.append([nr, nc])
                board[nr][nc] = 0


while True:
    n, m = map(int, input().split())
    cnt = 0

    if n == 0:
        break

    board = [list(map(int, input().split())) for _ in range(m)]
    
    for i in range(m):
        for j in range(n):
            if board[i][j] == 1:
                bfs(i, j, board, m, n)
                cnt += 1
    
    ans.append(cnt)

print("\n".join(map(str, ans)))