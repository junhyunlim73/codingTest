def solution(str_list, ex):
    answer = ''
    
    for s in str_list:
        if s.find(ex) == -1:
            answer += s
    
    return answer