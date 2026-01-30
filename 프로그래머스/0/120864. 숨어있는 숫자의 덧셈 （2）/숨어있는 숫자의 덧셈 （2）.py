def solution(my_string):
    answer = 0
    
    for i in my_string:
        if i.isalpha() == True:
            my_string = my_string.replace(i, ' ')
            
    lst = my_string.split(' ')
    
    for i in lst:
        if i.isdigit():
            answer += int(i)
    
    return answer