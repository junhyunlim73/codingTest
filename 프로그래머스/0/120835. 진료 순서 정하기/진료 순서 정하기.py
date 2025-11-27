def solution(emergency):
    answer = []
    
    s = sorted(emergency, reverse=True)
    
    for i in emergency:
        answer.append(s.index(i)+1)
    
    return answer