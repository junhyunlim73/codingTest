def solution(numbers, n):
    for i in range(len(numbers)):
        if n < sum(numbers[:i+1]):
            return sum(numbers[:i+1])