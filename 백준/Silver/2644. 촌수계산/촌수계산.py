n = int(input())
a, b = map(int, input().split())   
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    v, e = map(int, input().split())
    graph[v].append(e)
    graph[e].append(v)



def dfs(v, depth):
    if visited[v] != 0:
        return
    
    visited[v] += depth

    for i in graph[v]:
        if visited[i] == 0:
            dfs(i, depth+1)


dfs(a, 1)


if(visited[b] == 0):
    print(-1)
else:
    print(visited[b] - 1)