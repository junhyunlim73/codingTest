def solution(want, number, discount):
    answer = 0
    
    want_dict = {}
    
    for i in range(10):
        if discount[i] in want_dict:
            want_dict[discount[i]] += 1
        else:
            want_dict[discount[i]] = 1
    
    flag = False
    
    for i in range(len(want)):
        key = want[i]
        value = number[i]
        
        if key in want_dict:
            if value > want_dict[key]:
                flag = True
        else:
            flag = True
                
        if(flag == True):
            break
        
    if(flag == False):
        answer += 1
        
    l = len(discount) - 10
    
    for i in range(1, l+1):
        key1 = discount[i-1]
        
        want_dict[key1] -= 1
        
        key2 = discount[10 + i - 1]
        
        if key2 in want_dict:
            want_dict[key2] += 1
        else:
            want_dict[key2] = 1
        
        flag = False
    
        for i in range(len(want)):
            key = want[i]
            value = number[i]
        
            if key in want_dict:
                if value > want_dict[key]:
                    flag = True
            else:
                flag = True
                
            if(flag == True):
                break
        
        if(flag == False):
            answer += 1
        
    return answer