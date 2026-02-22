import sys
import math 
input = sys.stdin.readline

n, m = map(int, input().split())

isP = [False for _ in range(m+1)]
ans = []

isP[0] = isP[1] = True

for i in range(2, int(math.sqrt(m)) + 1):
    for j in range(i*i, m+1, i):
        if isP[j] == False:
            isP[j] = True

for i in range(n, m + 1):
    if isP[i] == False:
        ans.append(i)

print('\n'.join(map(str, ans)))