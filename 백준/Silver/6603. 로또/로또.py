import sys
from itertools import combinations

input = sys.stdin.readline

out = []

while True:
    lst = list(map(int, input().split()))

    n = lst[0]

    if n == 0:
        break

    for i in combinations(lst[1:], 6):
        out.append(" ".join(map(str, i)))
    
    out.append(" ")

print("\n".join(out))