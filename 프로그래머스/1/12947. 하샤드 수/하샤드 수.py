def solution(x):
    s = str(x)
    sum = 0

    for i in range(len(s)):
        sum += int(s[i])
        
    if x % sum == 0:
        return True
    else:
        return False