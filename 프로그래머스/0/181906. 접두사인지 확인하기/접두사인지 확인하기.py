def solution(my_string, is_prefix):
    l = len(is_prefix)
    
    if my_string[:l] == is_prefix:
        return 1
    
    return 0