import sys
from collections import deque 
input = sys.stdin.readline

n = int(input())
q = []
ans = []

for i in range(n):
    s = list(input().split())
    
    if s[0] == 'push':
        q.append(s[1])
    
    elif s[0] == 'pop':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q.pop())
    
    elif s[0] == 'top':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q[-1])
    
    elif s[0] == 'empty':
        if len(q) == 0:
            ans.append(1)
        else:
            ans.append(0)
    
    else:
        ans.append(len(q))

print('\n'.join(map(str, ans)))