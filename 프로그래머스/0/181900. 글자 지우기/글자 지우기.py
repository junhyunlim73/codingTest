def solution(my_string, indices):
    answer = ''
    
    l = len(my_string)
    is_lst = [True] * l
    
    for i in indices:
        is_lst[i] = False
            
    
    for i in range(len(my_string)):
        if is_lst[i] == True:
            answer += my_string[i]
    
    return answer