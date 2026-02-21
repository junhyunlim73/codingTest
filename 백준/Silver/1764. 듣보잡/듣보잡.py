import sys
from collections import deque 
input = sys.stdin.readline

n, m = map(int, input().split())

d = {}
ans = []

for i in range(n):
    name = input()
    d[name] = i

for i in range(m):
    name = input()

    if name in d:
        ans.append(name.strip())

ans.sort()

print(len(ans))
print("\n".join(map(str, ans)))