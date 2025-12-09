def solution(n):
    answer = 1
    
    m = 1
    
    while True:
        m = m * answer
        
        if n < m:
            return answer - 1
        
        answer = answer + 1
        
    return answer