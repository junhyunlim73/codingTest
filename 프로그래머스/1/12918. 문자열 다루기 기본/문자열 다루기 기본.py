def solution(s):
    return s.isdecimal() and (len(s) == 4 or len(s) == 6)