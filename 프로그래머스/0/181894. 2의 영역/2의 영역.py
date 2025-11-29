def solution(arr):
    if 2 not in arr:
        return [-1]
    
    idx = arr.index(2)
    lidx = len(arr) - arr[::-1].index(2)
    
    return arr[idx:lidx]