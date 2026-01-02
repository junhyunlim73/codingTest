def solution(arr, flag):
    answer = []
    
    for i in range(len(flag)):
        if flag[i]:
            answer += [arr[i]] * arr[i] * 2
        else:
            for _ in range(arr[i]):
                answer.pop()
    
    return answer