N = int(input())
answer = 0

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)


for i in range(len(a)):
    answer = answer + (a[i] * b[i])

print(answer)