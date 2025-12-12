def solution(num_list):
    answer = 0
    
    for num in num_list:
        while num != 1:
            num = num // 2
            answer = answer + 1
    
    return answer