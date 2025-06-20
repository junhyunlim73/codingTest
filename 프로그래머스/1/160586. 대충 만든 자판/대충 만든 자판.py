def solution(keymap, targets):
    answer = []
    my_dict = {}
    
    for i in range(len(keymap)):
        for j in range(len(keymap[i])):
            if keymap[i][j] not in my_dict:
                my_dict[keymap[i][j]] = j + 1
            else:
                my_dict[keymap[i][j]] = min(j + 1, my_dict.get(keymap[i][j]))

    for i in range(len(targets)):
        sum = 0
        flag = False
        for j in range(len(targets[i])):
            if targets[i][j] not in my_dict:
                flag = True
                break
            else:
                sum += my_dict.get(targets[i][j])

        if flag:
            answer.append(-1)
        else:
            answer.append(sum)
    
    return answer