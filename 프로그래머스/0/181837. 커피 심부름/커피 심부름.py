def solution(order):
    answer = 0
    ice = ["iceamericano", "americanoice", "icecafelatte", "cafelatteice", "americano", "cafelatte", "anything"]
    hot = ["hotamericano", "americanohot", "hotcafelatte", "cafelattehot"]
    
    for i in order:
        
        if i in ice:
            answer = answer + 4500
        else:
            answer = answer + 5000
    
    return answer