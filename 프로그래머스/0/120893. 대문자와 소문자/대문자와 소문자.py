def solution(my_string):
    answer = ''
    
    for s in my_string:
        if s.isupper():
            answer = answer + s.lower()
        else:
            answer = answer + s.upper()
        
    return answer