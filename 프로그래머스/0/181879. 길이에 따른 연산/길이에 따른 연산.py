def solution(num_list):
    answer = 1
    
    if len(num_list) > 10:
        return sum(num_list)
    
    else:
        for num in num_list:
            answer = answer * num
        
        return answer    
    
