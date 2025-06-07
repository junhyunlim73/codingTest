import math as m

def solution(n):
    num = m.sqrt(n)
    if (n / num == num) and (n % num == 0):
        return m.pow(num+1, 2)
    else:
        return -1