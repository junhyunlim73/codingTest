def solution(priorities, location):
    targets = sorted(priorities, reverse=True)
    idx = 0
    cnt = len(priorities)
    answer = []

    while len(targets) != 0:
        target = targets[0]
        if priorities[idx] == target:
            answer.append(idx)
            targets.remove(target)
    
        idx = (idx + 1) % cnt
    
    return (answer.index(location) + 1)