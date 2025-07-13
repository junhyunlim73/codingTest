def solution(n):
    answer = ''

    s = str(n)

    lst = []

    for i in range(len(s)):
        lst.append(s[i])

    lst.sort(reverse=True)

    for i in range(len(lst)):
        answer += lst[i]
    
    return int(answer)