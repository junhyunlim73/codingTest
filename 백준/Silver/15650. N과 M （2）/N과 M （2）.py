import sys
from itertools import combinations

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())

lst = [n for n in range(1, n + 1)]


for i in combinations(lst, m):
    for j in i:
        print(j, end = ' ')
    print()