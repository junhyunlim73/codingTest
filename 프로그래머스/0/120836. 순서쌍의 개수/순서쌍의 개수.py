import math

def solution(n):
    answer = 0
    
    for i in range(1, int(math.sqrt(n)) + 1):
        if n % i == 0:
            num = n // i
            
            if num == i:
                answer += 1
                
            else:
                answer += 2 
    
    return answer