def solution(n):
    num = n // 2
    
    if n % 2 == 0:
        return '수박' * num
    else:
        return '수박' * num + '수'