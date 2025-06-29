from itertools import permutations

N = int(input())
lst = [i for i in range(1, N + 1)]

for i in list(permutations(lst, N)):
    for idx in range(len(i)):
        print(i[idx], end=' ')
    print()