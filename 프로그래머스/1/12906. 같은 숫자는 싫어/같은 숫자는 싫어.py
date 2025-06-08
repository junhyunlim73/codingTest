def solution(arr):
    answer = []
    
    for i in range(len(arr)):
        idx = len(answer) - 1
        if idx == -1:
            answer.append(arr[i])
        else:
            if(answer[idx] != arr[i]):
                answer.append(arr[i])
                
    return answer