import sys
from collections import deque 
input = sys.stdin.readline

visited = [0 for i in range(100001)]

n, m = map(int, input().split())

q = deque()
q.append(n)
visited[n] = 1

while True:
    d = q.popleft()

    if d == m:
        break

    n1 = d - 1
    n2 = d + 1
    n3 = d * 2

    if n1 >= 0 and visited[n1] == 0:
        visited[n1] = visited[d] + 1
        q.append(n1)

    if n2 <= 100000 and visited[n2] == 0:
        visited[n2] = visited[d] + 1
        q.append(n2)

    
    if n3 <= 100000 and visited[n3] == 0:
        visited[n3] = visited[d] + 1
        q.append(n3)


print(visited[m] - 1)