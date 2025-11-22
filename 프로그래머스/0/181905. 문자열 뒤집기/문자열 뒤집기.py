def solution(my_string, s, e):
    my_lst = list(my_string[s:e+1])
    re_lst = my_lst[::-1]
    
    answer = my_string[:s] +  ''.join(re_lst) + my_string[e+1:]
    
    return answer