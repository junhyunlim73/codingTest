def solution(array, n):
    answer = 100
    l = 100
    
    for i in array:
        a = abs(n - i)
        
        if a == l:
            answer = min(answer, i)
        elif a < l:
            l = a
            answer = i
    
    return answer