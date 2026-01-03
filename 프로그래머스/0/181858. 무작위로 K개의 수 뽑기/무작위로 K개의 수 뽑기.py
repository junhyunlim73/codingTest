def solution(arr, k):
    answer = []
    
    for n in arr:
        if n not in answer:
            answer.append(n)
    
    l = k - len(answer)
    
    for _ in range(l):
        answer.append(-1)
        
    return answer[:k]