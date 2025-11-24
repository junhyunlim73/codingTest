def solution(my_string):
    answer = [0] * 52
    
    for i in range(len(my_string)):
        if my_string[i].isupper() == True:
            idx = ord(my_string[i]) - 65
        
        else:
            idx = ord(my_string[i]) - 71
        
        answer[idx] += 1
    
    return answer