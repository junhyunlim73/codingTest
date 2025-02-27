import sys
sys.setrecursionlimit(10**6) 
input = sys.stdin.readline

N, M, R = map(int, input().split(" "))

visited = [0] * (N+1)
adj = [[] for _ in range(N + 1)]

cnt = 1

def dfs(start):
    global cnt
    
    for d in adj[start]:
        if visited[d] == 0:
            cnt += 1
            visited[d] = cnt
            dfs(d)

for _ in range(M):
    a, b = map(int, input().split(" "))
    adj[a].append(b)
    adj[b].append(a)

for i in range(1, N + 1):
    adj[i].sort()

visited[R] = cnt
dfs(R)

for i in range(1 , N + 1):
    print(visited[i])