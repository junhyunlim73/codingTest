def solution(myString, pat):
    answer = 0 
    idx = 0
    
    while myString.find(pat,idx) != -1:
        answer = answer + 1
        idx = myString.find(pat,idx) + 1

    return answer