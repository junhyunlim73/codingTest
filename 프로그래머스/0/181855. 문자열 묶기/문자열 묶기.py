def solution(strArr):
    answer = 0
    d = {}
    
    for i in strArr:
        l = len(i)
        
        if l not in d:
            d[l] = 1
        else:
            d[l] = d[l] + 1
        
    
    for k in d:
        answer = max(answer, d[k])
    
    return answer