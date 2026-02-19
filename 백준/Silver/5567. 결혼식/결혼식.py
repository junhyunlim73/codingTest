import sys
from collections import deque 
input = sys.stdin.readline

n = int(input())
m = int(input())
cnt = 0

visited = [False for _ in range(n+1)]
graph = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = len(graph[1])
visited[1] = True
q = deque()

for i in graph[1]:
    q.append(i)
    visited[i] = True

while q:
    d = q.popleft()

    for i in graph[d]:
        if visited[i] == False:
            cnt += 1
            visited[i] = True

print(cnt)