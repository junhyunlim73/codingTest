def solution(n_str):
    idx = 0
    
    for s in n_str:
        if s != '0':
            return n_str[idx:]
        
        idx = idx + 1