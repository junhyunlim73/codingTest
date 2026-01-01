def solution(arr):
    answer = []
    
    for n in arr:
        for _ in range(n):
            answer.append(n)
    
    return answer