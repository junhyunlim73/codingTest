def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        f = commands[i][0]
        e = commands[i][1]
        idx = commands[i][2] - 1
        arr = array[f-1:e]
        arr.sort()
        answer.append(arr[idx])
    
    return answer