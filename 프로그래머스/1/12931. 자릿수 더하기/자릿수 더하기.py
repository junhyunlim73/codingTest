def solution(n):
    answer = 0

    nums = list(str(n))
    
    for n in nums:
        answer += int(n)

    return answer