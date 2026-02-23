import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

lst.sort()

ans = 0

for i in range(n):
    ans += lst[i] * (n - i)

print(ans)