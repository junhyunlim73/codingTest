import sys
from itertools import product

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())

lst = list(map(int, input().split()))

lst.sort()

for i in product(lst, repeat=m):
    for j in i:
        print(j, end = ' ')
    print()