def solution(sizes):
    answer = 0
    w = 0
    h = 0

    for i in range(len(sizes)):
        w = max(w, max(sizes[i][0], sizes[i][1]))
        h = max(h, min(sizes[i][0], sizes[i][1]))

    answer = w * h
    
    return answer