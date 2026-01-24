def solution(before, after):
    b_lst = sorted(list(before))
    a_lst = sorted(list(after))
    
    if b_lst == a_lst:
        return 1
    
    else:
        return 0
