import sys
from collections import deque 
input = sys.stdin.readline

n, m, k = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    v, e = map(int, input().split())
    graph[v].append(e)
    graph[e].append(v)

for i in range(1, n+1):
    graph[i].sort()

visited = [0 for _ in range(n+1)]

q = deque()
q.append(k)
visited[k] = 1
cnt = 1

while q:
    nq = q.popleft()

    for d in graph[nq]:
        if visited[d] == 0:
            q.append(d)
            cnt += 1
            visited[d] = cnt 

print("\n".join(map(str, visited[1:])))