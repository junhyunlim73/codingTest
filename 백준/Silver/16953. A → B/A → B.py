a,b = map(int, input().split())
answer = 1

while True:
    if a != 1 and b == 1:
        answer = -1
        break

    if b == a:
        break

    else:
        if b % 2 == 0:
            answer += 1
            b = b // 2
        
        else:
            s = str(b)
            if(s[-1] == "1"):
                b = int(s[:-1])
                answer += 1
            else:
                answer = -1
                break
        
print(answer)