def solution(str_list):
    if ('r' in str_list) and ('l' in str_list):
        lidx = str_list.index('l')
        ridx = str_list.index('r')
        
        if lidx < ridx:
            return str_list[:lidx]
        else:
            return str_list[ridx+1:]
    
    elif ('r' not in str_list) and ('l' in str_list):
        return str_list[:str_list.index('l')]
    
    elif ('r' in str_list) and ('l' not in str_list):
        return str_list[str_list.index('r')+1:]
    
    else:
        return []
    