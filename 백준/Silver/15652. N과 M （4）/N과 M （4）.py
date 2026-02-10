import sys
from itertools import combinations_with_replacement

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())

lst = [i for i in range(1, n+1)]

lst.sort()

for i in combinations_with_replacement(lst, m):
    for j in i:
        print(j, end = ' ')
    print()