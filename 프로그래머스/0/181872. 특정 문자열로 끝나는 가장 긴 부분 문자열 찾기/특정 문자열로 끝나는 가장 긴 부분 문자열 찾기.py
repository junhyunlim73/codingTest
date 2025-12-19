def solution(myString, pat):
    idx = -1
    
    while myString.find(pat, idx + 1) != -1:
        idx = myString.find(pat, idx + 1)
    
    return myString[:idx+len(pat)]