def solution(n):
    answer = 0
    lst = list(str(n))
    
    for num in lst:
        answer += int(num)
    
    return answer