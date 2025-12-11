def solution(arr):
    answer = 0
    
    while True:  
        new_arr = []
        flag = False
        
        for i in arr:
            if (50 <= i and (i % 2 == 0)):
                new_arr.append(i // 2)
            elif (i < 50 and (i % 2 == 1)):
                new_arr.append(i * 2 + 1)
            else:
                new_arr.append(i)        
        
        for i in range(len(arr)):
            if arr[i] != new_arr[i]:
                flag = True
                break
        
        if flag == False:
            return answer
        
        answer = answer + 1
        arr = new_arr
        