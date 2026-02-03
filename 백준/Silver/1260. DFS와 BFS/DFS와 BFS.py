import sys
from collections import deque
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M, V = map(int, input().split())

visited = [0 for _ in range(N + 1)]
graph = [[] for _ in range(N + 1)]

for i in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

for i in range(1, N+1):
    graph[i].sort()

def dfs(n):
    visited[n] = 1
    print(n, end = ' ')

    for d in graph[n]:
        if visited[d] == 0:
            dfs(d)

def bfs(n):
    q = deque()
    q.append(n)

    while q:
        v = q.popleft()

        if visited[v] == 0:
            visited[v] = 1
            print(v, end=' ')

            for d in graph[v]:
                if visited[d] == 0:
                    q.append(d)

dfs(V)
print()
visited = [0 for _ in range(N + 1)]
bfs(V)