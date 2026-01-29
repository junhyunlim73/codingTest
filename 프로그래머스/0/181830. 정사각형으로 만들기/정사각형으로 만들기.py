def solution(arr):
    n = len(arr[0])
    m = len(arr)
    
    if n == m:
        return arr
    elif n < m:
        l = m - n
        
        for i in range(m):
            for j in range(l):
                arr[i].append(0)
    
    else:
        l = n - m
        
        for i in range(l):
            arr.append([0] * n)
        
    return arr