answer = 0

def solution(number):
    arr = []
    combi(0, 0, number, arr)
    return answer

def combi(idx, depth, number, arr):
    if depth == 3:
        global answer
        if sum(arr) == 0:
            answer += 1
        
        return
    
    for i in range(idx, len(number)):
        arr.append(number[i])
        combi(i+1, depth+1, number, arr)
        arr.pop()