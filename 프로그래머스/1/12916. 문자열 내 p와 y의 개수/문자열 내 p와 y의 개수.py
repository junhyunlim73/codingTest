def solution(s):
    u = s.upper()

    if u.count('P') == u.count('Y'):
        return True
    else:
        return False