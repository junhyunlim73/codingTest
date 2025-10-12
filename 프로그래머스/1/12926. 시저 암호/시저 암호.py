def changeAlpha(a, n):
    if a.isupper():
        al = chr(((ord(a) - 65) + n) % 26 + 65)
        return al

    elif a.islower():
        al = chr(((ord(a) - 97) + n) % 26 + 97)
        return al

    else:
        return ' '

def solution(s, n):
    answer = ''
    lst = list(s)
    
    for i in lst:
        if i.isalpha() == True:
            answer += changeAlpha(i, n)
        else:
            answer += ' '
    
    return answer