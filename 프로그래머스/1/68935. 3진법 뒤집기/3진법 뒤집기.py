import math

def solution(n):
    answer = 0
    lst = []

    while n > 0:
        lst.append(n % 3)
        n //= 3

    l = len(lst) - 1

    for i in range(len(lst)):
        answer += lst[i] * math.pow(3, l - i)
        
    return answer