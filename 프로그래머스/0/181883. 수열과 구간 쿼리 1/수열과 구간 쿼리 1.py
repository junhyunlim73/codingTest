def solution(arr, queries):
    for i in queries:
        s = i[0]
        e = i[1]
        
        for j in range(s, e+1):
            arr[j] = arr[j] + 1
        
    
    return arr