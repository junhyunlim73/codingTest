def solution(arr, n):
    l = len(arr)
    
    if l % 2 == 0:
        for i in range(1, l, 2):
            arr[i] = arr[i] + n
    else:
        for i in range(0, l, 2):
            arr[i] = arr[i] + n
    
    return arr