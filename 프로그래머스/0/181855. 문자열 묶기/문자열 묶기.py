def solution(strArr):
    d = {}
    
    for i in strArr:
        l = len(i)
        
        if l not in d:
            d[l] = 1
        else:
            d[l] = d[l] + 1
    
    return max(d.values())