def solution(a, b):
    n = gcd(a, b)
    num = b // n
    
    print(num)
    
    for i in range(2, num + 1):
        if (i % 2 == 0) or (i % 5 == 0):
            continue
        
        if num % i == 0:
            return 2
        
    return 1

def gcd(a, b):
    tmp = 0
    
    while a > 0:
        tmp = b % a
        b = a
        a = tmp
    
    return b