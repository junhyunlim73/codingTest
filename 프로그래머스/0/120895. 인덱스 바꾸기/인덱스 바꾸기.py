def solution(my_string, num1, num2):
    str_lst = list(my_string)
    str_lst[num1], str_lst[num2] = str_lst[num2], str_lst[num1]
    
    return ''.join(str_lst)