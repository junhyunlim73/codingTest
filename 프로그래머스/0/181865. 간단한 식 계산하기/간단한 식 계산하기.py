def solution(binomial):
    num_lst = binomial.split()
    
    if num_lst[1] == '+':
        return int(num_lst[0]) + int(num_lst[2])
    
    elif num_lst[1] == '-':
        return int(num_lst[0]) - int(num_lst[2])
    
    else:
        return int(num_lst[0]) * int(num_lst[2])
    
