from itertools import combinations

def solution(numbers):
    answer = 0
    
    for a, b in combinations(numbers, 2):
        answer = max(answer, (a*b))
    
    return answer