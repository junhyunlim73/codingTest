def solution(s):
    answer = 0
    pre = 0
    lst = s.split(" ")
    
    for i in lst:
        if i == "Z":
            answer = answer - pre
        else:
            answer = answer + int(i)
            pre = int(i)
    
    return answer