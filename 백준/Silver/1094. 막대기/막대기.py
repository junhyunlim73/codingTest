X = int(input())

cnt = 0

while X > 0:
    if X % 2 == 1:
        cnt += 1;

    X >>= 1

print(cnt)