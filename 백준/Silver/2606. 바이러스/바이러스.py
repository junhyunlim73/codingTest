n = int(input())
m = int(input())

visited = [0] * (n+1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    v, e = map(int, input().split())
    graph[v].append(e)
    graph[e].append(v)


def dfs(v):
    visited[v] = 1

    for d in graph[v]:
        if visited[d] == 0:
            dfs(d)

dfs(1) 

print(sum(visited) - 1)