def solution(myString, pat):
    n_str = ''
    
    for i in myString:
        if i == 'A':
            n_str += 'B'
        else:
            n_str += 'A'
            
    if pat in n_str:
        return 1
    
    return 0