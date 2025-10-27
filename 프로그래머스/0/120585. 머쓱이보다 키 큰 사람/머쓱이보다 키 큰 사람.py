def solution(array, height):
    answer = 0
    
    for h in array:
        if height < h:
            answer += 1
    
    return answer