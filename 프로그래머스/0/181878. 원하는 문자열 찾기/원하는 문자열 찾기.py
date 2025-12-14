def solution(myString, pat):
    if len(myString) < len(pat):
        return 0
    
    else:
        
        if myString.lower().find(pat.lower()) == -1:
            return 0
        
        else:
            return 1
    