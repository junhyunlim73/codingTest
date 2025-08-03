from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())
visited = [False] * (n + 1)
graph = [[] * n for _ in range(n+1)]
cnt = 0

for _ in range(m):
    v, e = map(int, input().split())
    graph[v].append(e)
    graph[e].append(v)

def bfs(v, visited):
    q = deque([v])
    visited[v] = True

    while q:
        n = q.popleft()
        
        for d in graph[n]:
            if not visited[d]:
                q.append(d)
                visited[d] = True


for i in range(1, n + 1):
    if not visited[i]:
        bfs(i, visited)
        cnt += 1

print(cnt)